/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
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
        public static class ChangeRights implements DTO, Id {
            private Integer id;
        }
    }

    public enum Response {;
        /**
         * Получение информации о правах пользователя
         */
        @Value
        public static class Get implements DTO, Id, Name {
            Integer id;
            String name;
        }
    }
}
