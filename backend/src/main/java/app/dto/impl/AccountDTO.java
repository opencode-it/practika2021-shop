/*
 * Uliana
 */
package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
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

    public enum Request implements RequestDTO {;

        /**
         * Получение пользователя по его ID
         */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO  {
            private Integer id;
        }

        /**
         * Используется при регистрации пользователя
         */
        @Data
        @AllArgsConstructor
        public static class Create implements Rights, Email, FullName, Address, Token, RequestDTO {
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
        @AllArgsConstructor
        public static class UpdateName implements Id, FullName, RequestDTO {
            private Integer id;
            private String fullName;
        }

        /**
         * Запрос пользователя на изменение почты
         */
        @Data
        @AllArgsConstructor
        public static class UpdateEmail implements Id, Email, RequestDTO {
            private Integer id;
            private String email;
        }

        /**
         * Запрос пользователя на изменение адреса
         */
        @Data
        @AllArgsConstructor
        public static class UpdateAddress implements Id, Address, RequestDTO {
            private Integer id;
            private String address;
        }

        /**
         * Запрос пользователя на удаление своего аккаунта
         */
        @Data
        @AllArgsConstructor
        public static class Delete implements Id, RequestDTO {
            private Integer id;
        }
    }

    public enum Response implements ResponseDTO{;

        /**
        * Основная информация о пользователе
        */
        @Value
        public static class GetShortInfo implements Email, FullName, ResponseDTO  {
            String email;
            String fullName;
        }

        /**
         * Полная информация о пользователе
         */
        @Value
        public static class GetFullInfo implements Id, Rights, Email, FullName, Token, Address, ResponseDTO {
            Integer id;
            RightsDTO.Response.Get rights;
            String email;
            String fullName;
            String address;
            String token;
        }

    }

}
