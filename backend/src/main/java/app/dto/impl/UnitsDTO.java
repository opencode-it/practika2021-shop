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
 * запросы и ответы по величине мерочной
 * характеристике конкретного продукта
 */
public enum UnitsDTO implements DTO {;
    private interface Id {
        Integer getId();
    }

    /**
     * Название того, в чем измеряется
     * характеристика
     */
    private interface Name {
        String getName();
    }

    //TODO я не уверена, нужны ли Units действительные мерки, поэтому просто пока оставлю тут
    /**
     * Размер характеристики
     */
    private interface Measure {
        Double getMeasure();
    }

    public enum Request {;
        /**
         * Для запроса на изменения значения размера
         * мерочной характеристики по ее ID
         */
        @Data
        public static class ChangeUnits implements Id, Measure, RequestDTO {
            private Integer id;
            private Double measure;
        }
    }

    public enum Response {;
        /**
         * Ответ запроса на получение размера
         * мерочно характеристики продукта
         */
        @Value
        public static class Get implements Name, Measure, ResponseDTO {
            String name;
            Double measure;
        }
    }
}
