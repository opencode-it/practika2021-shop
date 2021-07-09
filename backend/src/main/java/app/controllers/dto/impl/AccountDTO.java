/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по аккаунту пользователя
 */
public enum AccountDTO implements DTO {;

    private interface Id {
        Integer getId();
    }

    /**
     * Что-то для Outh2
     */
    private interface Token {
        String getToken();
    }

    /**
     * Для определения прав пользователя
     */
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

        /**
         * Получение пользователя по его ID
         */
        @Data
        public static class Get implements Id {
            private Integer id;
        }

        /**
         * Используется при регистрации пользователя
         */
        @Data
        public static class Create implements Rights, Email, FullName, Address, Token {
            private String rights;
            private String email;
            private String fullName;
            private String address;
            private String token;
        }

        /**
         * Запрос пользователя на изменение имени
         */
        @Data
        public static class UpdateName implements Id, FullName {
            private Integer id;
            private String fullName;
        }

        /**
         * Запрос пользователя на изменение почты
         */
        @Data
        public static class UpdateEmail implements Id, Email {
            private Integer id;
            private String email;
        }

        /**
         * Запрос пользователя на изменение адреса
         */
        @Data
        public static class UpdateAddress implements Id, Address {
            private Integer id;
            private String address;
        }

        /**
         * Запрос пользователя на удаление своего аккаунта
         */
        @Data
        public static class Delete implements Id {
            private Integer id;
        }
    }

    public enum Response {;

        /**
        * Основная информация о пользователе
        */
        @Value
        public static class GetShortInfo implements Email, FullName {
            String email;
            String fullName;
        }

        /**
         * Полная информация о пользователе
         */
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
