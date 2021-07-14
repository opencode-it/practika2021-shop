package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
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
        Long getId();
    }

    public enum Request {;

        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }

        @Data
        @AllArgsConstructor
        public static class UpdateName implements Id, Name, RequestDTO {
            private Long id;
            private String name;
        }

        @Data
        @AllArgsConstructor
        public static class Delete implements Id, RequestDTO {
            private Long id;
        }
    }

    public enum Response {;

        @Value
        public static class getName implements Name, ResponseDTO {
            private String name;
        }

    }

}
