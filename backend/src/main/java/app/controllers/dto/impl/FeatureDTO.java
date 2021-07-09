/*
  Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по характеристикам конкретного продукта
 */
public enum FeatureDTO {;

    private interface Id {
        Integer getId();
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
        public static class Get implements DTO, Id {
            private Integer id;
        }

        /**
         * Для изменения мерочной характеристики товара по ее ID
         * на новое значение
         */
        @Data
        public static class UpdateUnits implements DTO, Id, ChangeUnits {
            private Integer Id;
            private UnitsDTO.Request.ChangeUnits changesUnits;
        }

        /**
         * Для изменнеия безмерочной характеристики товара по ее ID
         * на новое значение
         */
        @Data
        public static class UpdateValue implements DTO, Id, FeatureValue {
            private Integer Id;
            private String featureValue;
        }

        /**
         * Для удаления характеристики товара по ее ID
         */
        @Data
        public static class Delete implements DTO, Id {
            private Integer Id;
        }

    }

    public enum Response {;
        /**
         * Возвращает информацию о мерочной характеристике
         * продукта
         */
        @Value
        public static class GetWithUnits implements DTO, Name, FeaturePrice, ResponseUnits {
            String name;
            UnitsDTO.Response.Get units;
            Integer featurePrice;
        }

        /**
         * Возвращает информацию о безмерочной характеристике
         * продукта
         */
        @Value
        public static class GetUnitless implements DTO, Name, FeaturePrice, FeatureValue {
            String name;
            String featureValue;
            Integer featurePrice;
        }

    }

}
