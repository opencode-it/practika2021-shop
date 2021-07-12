/*
 * Uliana
 */
package app.dto.impl;

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
        public static class CheckRights implements Id, RequestDTO {
            private Integer id;
        }

        /**
         * Для смены прав пользователя
         */
        @Data
        public static class ChangeRights implements Id, Name, RequestDTO {
            private Integer id;
            private String name;
        }
    }

    public enum Response {;
        /**
         * Получение информации о правах пользователя
         */
        @Value
        public static class Get implements Id, Name, ResponseDTO {
            Integer id;
            String name;
        }
    }
}
