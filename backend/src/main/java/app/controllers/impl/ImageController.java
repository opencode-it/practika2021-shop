package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.ImageDTO;
import app.services.ext.ImageGetService;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Контроллер, работающий с изображениями,
 * поступающими на сервер
 */
@RestController
@RequestMapping("/assets/images")
public class ImageController extends RESTController<ImageDTO.Request.Get,
                                                        ImageDTO.Response.GetImage,
                                                        ImageGetService> {
    //Изображения изначально поступают на клиент вместе
    //с товарами или заказами, поэтому путь к ним и
    //их предназначение всегда известны

    @Value("${minio.ip}")
    private String ip;

    @Value("${minio.bucket}")
    private String bucketName;

    @Value("${minio.accessKey}")
    private String accessKey;


    @Value("${minio.secretKey}")
    private String secretKey;


    /**
     * Метод, срабатывающтй при POST запросе, с путём /assets/images/upload
     * @param file - фалй с изображением
     * @return Возвращает строку с сообщением
     */
    @PostMapping("/upload")
    public String minioUpload(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            boolean bucketExists = minioClient.bucketExists(bucketName);
            if (bucketExists) {

            } else {
                minioClient.makeBucket(bucketName);
            }
            if (file.getSize() <= 20971520) {
                // fileName пусто, что указывает на загрузку с использованием имени исходного файла
                if (fileName == null) {
                    fileName = file.getOriginalFilename();
                    fileName = fileName.replaceAll(" ", "_");
                }

                // имя мини-склада
                minioClient.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
                String fileUrl = bucketName + "/" + fileName;
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("fileUrl", fileUrl);
                map.put("bucketName", bucketName);
                map.put("originFileName", fileName);
                return "OKEY";
            }else return "Отсутвует файл";

        } catch (Exception e) {
            e.printStackTrace();
            return "Ошибка загрузки";
        }

    }

    /**
     * Метод, срабатывающтй при GET запросе, с путём /assets/images//down/{fileName}
     * @param objectName - имя файла с изображением
     * @param response
     * @return Возвращает строку с сообщением
     */
    @GetMapping("/down/{fileName}")
    public String downloadFile(@PathVariable("fileName") String objectName, HttpServletResponse response) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            InputStream file = minioClient.getObject(bucketName,objectName);
            String filename = new String(objectName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while((len=file.read(buffer)) > 0){
                servletOutputStream.write(buffer, 0, len);
            }
            servletOutputStream.flush();
            file.close();
            servletOutputStream.close();
            return "загрузка прошла успешно";
        } catch (Exception e) {
            e.printStackTrace();
            return"Ошибка загрузки: [" + e.getMessage () + "】";
        }
    }
    public String chek(){
        return "DA";
    }
    /**
     * Метод, срабатывающтй при POST запросе, с путём /assets/images//down/{fileName}
     * @param fileName - имя файла с изображением
     * @return Возвращает true при успешном удалении
     */
    @DeleteMapping("/{fileName}")
    public boolean delete(@PathVariable("fileName") String fileName) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            minioClient.removeObject(bucketName,fileName);

            return true;
        } catch (Exception e) {

            return false;
        }
    }
    /**
     * Проверка на существание файла
     * @param fileName - имя файла с изображением
     * @return Возвращает true, если файл существет
     */
    public boolean isFileExisted(String fileName) {
        InputStream inputStream = null;
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            inputStream = minioClient.getObject(bucketName, fileName);
            if (inputStream != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}