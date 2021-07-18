/*
  Uliana
 */
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.Id;
import app.dto.interfaces.feature.FeaturePrice;
import app.dto.interfaces.feature.FeatureValue;
import app.dto.interfaces.Name;
import app.dto.interfaces.feature.ResponseUnits;
import app.dto.interfaces.feature.Units;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по характеристикам конкретного продукта
 */
public enum FeatureDTO {;

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
        public static class UpdateUnits implements Id, Units, RequestDTO  {
            private Long Id;
            private UnitsDTO.Request.Get units;
        }

        @Data
        @AllArgsConstructor
        public static class AddFeature implements Id, Name, FeatureValue, FeaturePrice, Units, RequestDTO {
            private Long id;
            private String name;
            private String featureValue;
            private UnitsDTO.Request.Get units;
            private Integer featurePrice;
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
