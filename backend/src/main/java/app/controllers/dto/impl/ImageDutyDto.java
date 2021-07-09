package app.controllers.dto;

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
        public static class Get implements Id {
            private Integer id;
        }

        @Data
        public static class UpdateName implements Id, Name {
            private Integer id;
            private String name;
        }

        @Data
        public static class Delete implements Id {
            private Integer id;
        }


    }

    public enum Response {;

        @Value
        public static class getName implements Name {
            private String name;
        }

    }

}
