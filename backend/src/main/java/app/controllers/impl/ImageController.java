package app.controllers.impl;

import app.components.Minio;
import app.controllers.RESTController;
import app.dto.impl.ImageDTO;
import app.services.ext.ImageGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Tag(name = "Изображения", description = "Контроллер, работающий с изображениями, поступающими на сервер")
@RestController
@RequestMapping("/assets/images")
public class ImageController extends RESTController<ImageDTO.Request.Get,
                                                        ImageDTO.Response.GetImage,
                                                        ImageGetService> {
    @Autowired
    private Minio minio;

    /**
     * Метод, срабатывающтй при POST запросе, с путём /assets/images/upload
     * @param file - фалй с изображением
     * @return Возвращает строку с сообщением
     */
    @Operation(
            summary = "Загрузить файл",
            description = "Загрузить изображение на сервер и получить сообщение"
    )
    @PostMapping("/upload")
    public boolean minioUpload(MultipartFile file) {
        return minio.minioUpload(file);
    }



    /**
     * Метод, срабатывающтй при GET запросе, с путём /assets/images//down/{fileName}
     * @param objectName - имя файла с изображением
     * @param response
     * @return Возвращает строку с сообщением
     */
    @Operation(
            summary = "Скачать файл",
            description = "Скачать изображение с сервера и получить сообщение"
    )
    @GetMapping("/down/{fileName}")
    public String downloadFile(@PathVariable("fileName") String objectName, HttpServletResponse response) {
        return minio.downloadFile(objectName, response);
    }



    /**
     * Метод, срабатывающтй при POST запросе, с путём /assets/images//down/{fileName}
     * @param fileName - имя файла с изображением
     * @return Возвращает true при успешном удалении
     */
    @Operation(
            summary = "Удалить файл",
            description = "Удалить изображение с сервера"
    )
    @DeleteMapping("/{fileName}")
    public boolean delete(@PathVariable("fileName") String fileName) {
        return  minio.delete(fileName);
    }



    /**
     * Проверка на существание файла
     * @param fileName - имя файла с изображением
     * @return Возвращает true, если файл существет
     */
    public boolean isFileExisted(String fileName) {
       return minio.isFileExisted(fileName);
    }

}