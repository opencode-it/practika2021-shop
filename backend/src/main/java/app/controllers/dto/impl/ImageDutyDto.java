package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

/**
 * @author SuvorovNikita
 */

public enum ImageDutyDto {;

    private interface Name {
        String getName();
    }

    private interface Id {
        Integer getId();
    }

    public enum Request {;

        @Data
        public static class Get implements DTO, Id {
            private Integer id;
        }

        @Data
        public static class UpdateName implements DTO, Id, Name {
            private Integer id;
            private String name;
        }

        @Data
        public static class Delete implements DTO, Id {
            private Integer id;
        }


    }

    public enum Response {;

        @Value
        public static class getName implements DTO, Name {
            private String name;
        }

    }

}
