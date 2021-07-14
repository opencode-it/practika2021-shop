package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
/**
 * @author ZubchenkoArtem
 * */
public enum ImageDTO {;

    private interface Path {
        String getPath();
    }

    private interface ImageDuty {
        String getImageDuty();
    }





    private interface ImageFile {}


    public enum Request {;
        /**
        * Для запроса изображений конкретного продукта
        */
        @Data
        @AllArgsConstructor
        public static class Get implements ImageDuty, RequestDTO  {
            String imageDuty;
        }

        /**
         * Создает свое изображение
         */
        @Data
        @AllArgsConstructor
        public static class LoadCustom implements ImageFile, ImageDuty, RequestDTO {
            //TODO в чем грузятся изображения на сервер?

            private String imageDuty;
        }

        @Data
        @AllArgsConstructor
        public static class CustomizeImage implements Path,
                                                        ImageDuty,
                                                        RequestDTO {
            private String path;
            private String imageDuty;

        }

        /**
         * Удалить изображение по указанному пути
         */
        @Data
        @AllArgsConstructor
        public static class DeleteImage implements Path, RequestDTO {
            private String path;
        }
    }

    public enum Response {;

        /**
         * Стандартная загрузка изображений
         */
        @Value
        public static class GetImage implements Path, ImageDuty, ResponseDTO {
            String path;
            String ImageDuty;
        }

        /**
         * Дополнительная подгрузка изображения для конкретного объекта
         */
        @Value
        public static class GetRequestedImage implements  Path, ImageDuty, ResponseDTO {
            private Integer productId;
            String path;
            String ImageDuty;
        }

    }
}
