/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

/**
 * Общий енам для ДТО объектов класса продукта
 * Содержит енамы для Запроса и Ответа
 */
public enum AccountDTO implements DTO {;

    private interface Id {
        Integer getId();
    }

    private interface Token {
        String getToken();
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

    private interface Address {
        String getAddress();
    }

    public enum Request {;

        @Data
        public static class Get implements Id {
            private Integer id;
        }

        @Data
        public static class Create implements Rights, Email, FullName, Address, Token {
            private String rights;
            private String email;
            private String fullName;
            private String address;
            private String token;
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
        public static class UpdateAddress implements Id, Address {
            private Integer id;
            private String address;
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
        public static class GetFullInfo implements Id, Rights, Email, FullName, Token, Address {
            Integer id;
            String rights;
            String email;
            String fullName;
            private String address;
            private String token;
        }

    }

}
