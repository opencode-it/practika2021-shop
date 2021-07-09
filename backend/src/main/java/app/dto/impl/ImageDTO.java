package app.dto.impl;

import app.dto.DTO;
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

    public enum Request {;
        @Data
        public static class Get implements DTO, Path, ImageDuty {
            String path;
            String ImageDuty;

        }

        /**
         * Создает свое изображение
         */
        @Data
        public static class CreateCustom implements DTO, Path, ImageDuty {
            private String path;
            private String ImageDuty;

        }
    }

    public enum Response {;

        @Value
        public static class GetImage implements DTO, Path, ImageDuty {
            String path;
            String ImageDuty;
        }

    }
}
