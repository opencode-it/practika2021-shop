/*
 * Uliana
 */
package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по правам пользователя
 */
public enum RightsDTO {;
    private interface Id {
        Integer getId();
    }

    private interface Name {
        String getName();
    }

    public enum Request {;
        /**
        * На проверку прав пользователя
        */
        @Data
        public static class CheckRights implements DTO, Id {
            private Integer id;
        }

        /**
         * Для смены прав пользователя
         */
        @Data
        public static class ChangeRights implements DTO, Id, Name, RequestDTO {
            private Integer id;
            private String name;
        }
    }

    public enum Response {;
        /**
         * Получение информации о правах пользователя
         */
        @Value
        public static class Get implements DTO, Id, Name, ResponseDTO {
            Integer id;
            String name;
        }
    }
}
