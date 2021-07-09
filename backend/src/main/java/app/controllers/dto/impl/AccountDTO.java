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
public enum AccountDTO {;

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
        RightsDTO.Response.Get getRights();
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
        public static class Get implements DTO, Id {
            private Integer id;
        }

        /**
         * Используется при регистрации пользователя
         */
        @Data
        public static class Create implements DTO, Rights, Email, FullName, Address, Token {
            private RightsDTO.Response.Get rights;
            private String email;
            private String fullName;
            private String address;
            private String token;
        }

        /**
         * Запрос пользователя на изменение имени
         */
        @Data
        public static class UpdateName implements DTO, Id, FullName {
            private Integer id;
            private String fullName;
        }

        /**
         * Запрос пользователя на изменение почты
         */
        @Data
        public static class UpdateEmail implements DTO, Id, Email {
            private Integer id;
            private String email;
        }

        /**
         * Запрос пользователя на изменение адреса
         */
        @Data
        public static class UpdateAddress implements DTO, Id, Address {
            private Integer id;
            private String address;
        }

        /**
         * Запрос пользователя на удаление своего аккаунта
         */
        @Data
        public static class Delete implements DTO, Id {
            private Integer id;
        }
    }

    public enum Response {;

        /**
        * Основная информация о пользователе
        */
        @Value
        public static class GetShortInfo implements DTO, Email, FullName {
            String email;
            String fullName;
        }

        /**
         * Полная информация о пользователе
         */
        @Value
        public static class GetFullInfo implements DTO, Id, Rights, Email, FullName, Token, Address {
            Integer id;
            RightsDTO.Response.Get rights;
            String email;
            String fullName;
            String address;
            String token;
        }

    }

}
