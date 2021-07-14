/*
 * Uliana
 */
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по правам пользователя
 */
public enum RightsDTO {;
    private interface Id {
        Long getId();
    }

    private interface Name {
        String getName();
    }

    public enum Request {;
        /**
        * На проверку прав пользователя
        */
        @Data
        @AllArgsConstructor
        public static class CheckRights implements Id, RequestDTO {
            private Long id;
        }

        /**
         * Для смены прав пользователя
         */
        @Data
        @AllArgsConstructor
        public static class ChangeRights implements Id, Name, RequestDTO {
            private Long id;
            private String name;
        }
    }

    public enum Response {;
        /**
         * Получение информации о правах пользователя
         */
        @Value
        public static class Get implements Id, Name, ResponseDTO {
            Long id;
            String name;
        }
    }
}
