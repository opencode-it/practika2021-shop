package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.image.FileName;
import app.dto.interfaces.image.ImageDuty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
/**
 * @author ZubchenkoArtem
 * */
public enum ImageDTO {;

    public enum Request {;
        /**
        * Для запроса изображений конкретного продукта
        */
        @Data
        @AllArgsConstructor
        public static class Get implements ImageDuty, RequestDTO  {
            String imageDuty;
        }


        @Data
        @AllArgsConstructor
        public static class CustomizeImage implements FileName,
                                                        ImageDuty,
                                                        RequestDTO {
            private String fileName;
            private String imageDuty;

        }

        /**
         * Удалить изображение по указанному пути
         */
        @Data
        @AllArgsConstructor
        public static class DeleteImage implements FileName, RequestDTO {
            private String fileName;
        }
    }

    public enum Response {;

        /**
         * Стандартная загрузка изображений
         */
        @Value
        public static class GetImage implements FileName, ImageDuty, ResponseDTO {
            String fileName;
            String ImageDuty;
        }

        /**
         * Дополнительная подгрузка изображения для конкретного объекта
         */
        @Value
        public static class GetRequestedImage implements FileName, ImageDuty, ResponseDTO {
            Integer productId;
            String fileName;
            String ImageDuty;
        }

    }
}
