/*
  Uliana
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
 * запросы и ответы по характеристикам конкретного продукта
 */
public enum FeatureDTO {;

    private interface Id {
        Long getId();
    }

    private interface Name {
        String getName();
    }

    /**
     * Содержит информацию о измеряемой
     * характеристики продукта
     * для клиента
     */
    private interface ResponseUnits {
        UnitsDTO.Response.Get getUnits();
    }

    /**
     * Содержит информацию об изменении
     * измеряемой характеристики продукта
     * для сервера
     */
    private interface ChangeUnits {
        UnitsDTO.Request.ChangeUnits getChangesUnits();
    }

    /**
     * Ссодержит значение безмерочной
     * характеристики продукта
     */
    private interface FeatureValue {
        String getFeatureValue();
    }

    private interface FeaturePrice {
        Integer getFeaturePrice();
    }

    public enum Request {;

        /**
        * Для получения характеристики с сервера по ее ID
        */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }

        /**
         * Для изменения мерочной характеристики товара по ее ID
         * на новое значение
         */
        @Data
        @AllArgsConstructor
        public static class UpdateUnits implements Id, ChangeUnits, RequestDTO  {
            private Long Id;
            private UnitsDTO.Request.ChangeUnits changesUnits;
        }

        /**
         * Для изменнеия безмерочной характеристики товара по ее ID
         * на новое значение
         */
        @Data
        @AllArgsConstructor
        public static class UpdateValue implements Id, FeatureValue, RequestDTO  {
            private Long Id;
            private String featureValue;
        }

        /**
         * Для удаления характеристики товара по ее ID
         */
        @Data
        @AllArgsConstructor
        public static class Delete implements Id, RequestDTO  {
            private Long Id;
        }

    }

    public enum Response {;
        /**
         * Возвращает информацию о мерочной характеристике
         * продукта
         */
        @Value
        public static class GetWithUnits implements Name, FeaturePrice, ResponseUnits, ResponseDTO {
            String name;
            UnitsDTO.Response.Get units;
            Integer featurePrice;
        }

        /**
         * Возвращает информацию о безмерочной характеристике
         * продукта
         */
        @Value
        public static class GetUnitless implements Name, FeaturePrice, FeatureValue, ResponseDTO  {
            String name;
            String featureValue;
            Integer featurePrice;
        }

    }

}
