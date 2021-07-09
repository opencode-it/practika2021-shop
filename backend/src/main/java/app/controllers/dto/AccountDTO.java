package app.controllers.dto;

import lombok.Data;
import lombok.Value;

public enum AccountDTO {;

    private interface Id {
        Integer getId();
    }

    private interface Rights {
        String getRights();
    }

    private interface Email {
        String getEmail();
    }

    private interface FullName {
        String getFullName();
    }

    public enum Request {;

        @Data
        public static class Get implements Id {
            private Integer id;
        }

        @Data
        public static class Create implements Rights, Email, FullName {
           private String rights;
           private String email;
           private String fullName;
        }

        @Data
        public static class UpdateName implements Id, FullName {
            private Integer id;
            private String fullName;
        }

        @Data
        public static class UpdateEmail implements Id, Email {
            private Integer id;
            private String email;
        }

        @Data
        public static class Delete implements Id {
            private Integer id;
        }


    }

    public enum Response {;

        @Value
        public static class GetShortInfo implements Email, FullName {
            String email;
            String fullName;
        }

        @Value
        public static class GetFullInfo implements Id, Rights, Email, FullName {
            Integer id;
            String rights;
            String email;
            String fullName;
        }

    }

}
