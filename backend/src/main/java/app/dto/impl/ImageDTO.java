package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
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

    private interface RequestForProduct {
        Integer getProductId();
    }

    private interface ImageFile {}


    public enum Request {;
        /**
        * Для запроса изображений конкретного продукта
        */
        @Data
        public static class Get implements ImageDuty, RequestForProduct, RequestDTO  {
            Integer productId;
            String imageDuty;
        }

        /**
         * Создает свое изображение
         */
        @Data
        public static class CreateCustom implements ImageFile, ImageDuty, RequestDTO {
            //TODO в чем грузятся изображения на сервер?

            private String ImageDuty;

        }

        /**
         * Удалить изображение по указанному пути
         */
        @Data
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
        public static class GetRequestedImage implements RequestForProduct, Path, ImageDuty, ResponseDTO {
            private Integer productId;
            String path;
            String ImageDuty;
        }

    }
}
