package app.controllers.dto.impl;

import app.controllers.dto.ImageDutyDto;
import lombok.Data;
import lombok.Value;
/**
 * @author ZubchenkoArtem
 * */
public enum ImageDTO  {
    ;

    private interface Path {
        String getPath();
    }

    private interface ImageDuty  {
        ImageDutyDto.Request.Get getImageDyte();
    }


    public enum Request {;

        @Data
        public static class Get implements Path, ImageDuty {
            String path;
            String imageDyte;


        }

        /**
         * Создает свое изображение
         */
        @Data
        public static class CreateCustom implements Path, ImageDuty {
            private String path;
            private String ImageDuty;


            @Override
            public ImageDutyDto.Request.Get getImageDyte() {
                return null;
            }
        }
        }



    public enum Response {
        ;

        @Value
        public static class GetImage implements Path, ImageDuty {
            String path;
            String ImageDuty;


            @Override
            public ImageDutyDto.Request.Get getImageDyte() {
                return null;
            }
        }

    }
}
