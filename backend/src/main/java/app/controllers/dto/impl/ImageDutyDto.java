package app.controllers.dto.impl;

import lombok.Data;
import lombok.Value;

public enum ImageDutyDto {;

    private interface Name {
        String getName();
    }

    public enum Request {;

        @Data
        public static class Get implements Name {
            String name;
        }

    }

    public enum Response {;

        @Value
        public static class getName implements Name {
            String name;
        }
    }

}
