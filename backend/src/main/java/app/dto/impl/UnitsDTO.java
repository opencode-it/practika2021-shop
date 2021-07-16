/*
 * Uliana
 */
package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.Id;
import app.dto.interfaces.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по величине мерочной
 * характеристике конкретного продукта
 */
public enum UnitsDTO implements DTO {;

    public enum Request {;
        /**
         * Для запроса на получение единицы измерения фичи
         */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }


        /**
         * Для запроса на изменения значения размера
         * мерочной характеристики по ее ID
         */
        @Data
        @AllArgsConstructor
        public static class AddUnits implements Id, Name, RequestDTO {
            private Long id;
            private String name;
        }
    }

    public enum Response {;
        /**
         * Ответ запроса на получение размера
         * мерочно характеристики продукта
         */
        @Value
        public static class Get implements Id, Name, ResponseDTO {
            Long id;
            String name;
        }
    }
}
