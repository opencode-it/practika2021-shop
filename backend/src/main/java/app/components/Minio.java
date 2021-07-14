package app.components;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class Minio {

    @Value("${spring.minio.url}")
    private String url;

    @Value("${spring.minio.bucket}")
    private String bucketName;

    @Value("${spring.minio.access-key}")
    private String accessKey;


    @Value("${spring.minio.secret-key}")
    private String secretKey;


    /**
     * Метод щагрудающий в minio file
     * @param file - фалй с изображением
     * @return Возвращает true при удачной загрузки
     */
    public boolean minioUpload(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
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
                return true;
            }else return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Метод отправляющий файл клиенту
     * @param objectName - имя файла с изображением
     * @param response
     * @return Возвращает строку с сообщением
     */
    public String downloadFile(String objectName, HttpServletResponse response) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
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
            return"Ошибка загрузки: [";
        }
    }

    /**
     * Метод, удаляющий файл из minio
     * @param fileName - имя файла с изображением
     * @return Возвращает true при успешном удалении
     */
    public boolean delete(@PathVariable("fileName") String fileName) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            minioClient.removeObject(bucketName,fileName);

            return true;
        } catch (Exception e) {

            return false;
        }
    }
    /**
     * Проверка на существание файла в minio
     * @param fileName - имя файла с изображением
     * @return Возвращает true, если файл существет
     */
    public boolean isFileExisted(String fileName) {
        InputStream inputStream = null;
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
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
