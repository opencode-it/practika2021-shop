/*
 * Uliana
 */
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.account.Address;
import app.dto.interfaces.account.Email;
import app.dto.interfaces.account.FullName;
import app.dto.interfaces.Id;
import app.dto.interfaces.account.Rights;
import app.dto.interfaces.account.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по аккаунту пользователя
 */
public enum AccountDTO {;

    public enum Request implements RequestDTO {;

        /**
         * Получение пользователя по его ID
         */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO  {
            private Long id;
        }

        /**
         * Используется при регистрации пользователя
         */
        @Data
        @AllArgsConstructor
        public static class Create implements Id, Rights, Email, FullName, Address, Token, RequestDTO {
            private Long id;
            private RightsDTO.Response.Get rights;
            private String email;
            private String fullName;
            private String address;
            private String token;
        }

        /**
         * Запрос пользователя на удаление своего аккаунта
         */
        @Data
        @AllArgsConstructor
        public static class Delete implements Id, RequestDTO {
            private Long id;
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
            Long id;
            RightsDTO.Response.Get rights;
            String email;
            String fullName;
            String address;
            String token;
        }

    }

}
