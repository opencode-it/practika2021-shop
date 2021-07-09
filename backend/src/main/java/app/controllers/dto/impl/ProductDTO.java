/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

import java.util.Set;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по продуутам
 */
public enum ProductDTO implements DTO {;

    private interface Id {
        Integer getId();
    }

    //TODO не помнбю, было ли у класса продукта имя, но на схеме вроде точно не было
    private interface Name {
        String getName();
    }

    private interface Description {
        String getDescription();
    }

    private interface Type {
        String getType();
    }

    /**
     * Для фильтрации общего списка продуктов
     * по конкретным характеристикам
     */
    private interface GetFeatures {
        Set<FeatureDTO.Request.Get> getFeaturesFilter();
    }

    /**
     * Мерочные характеристики продукта
     */
    private interface UnitsFeatures {
        Set<FeatureDTO.Response.GetWithUnits> getUnitsFeatures();
    }

    /**
     * Безмерочные характеристики продукта
     */
    private interface Features {
        Set<FeatureDTO.Response.GetUnitless> getFeatures();
    }

    /**
     * Превьюшное изображение продукта
     */
    private interface Image {
        ImageDTO.Response.GetImage getImage();
    }

    /**
     * Все доступные изображения продукта
     */
    private interface ImagesSet {
        Set<ImageDTO.Response.GetImage> getImages();
    }

    /**
     * Наценка за счет изменения характеристик
     */
    private interface AdditionalPrice {
        BigDecimal getAdditionalPrice();
    }

    /**
     * Изначальная цена продукта без конкретных изменений
     */
    private interface BasePrice {
        BigDecimal getBasePrice();
    }

    /**
     * Полная суммированная стоимость продукта
     */
    private interface FullPrice {
        BigDecimal getFullPrice();
    }

    /**
     * Состояние наличия продукта
     */
    private interface Status {
        String getStatus();
    }

    public enum Request {;

        /**
        * Запрос на продукт по его ID
        */
        @Data
        public static class Get implements Id {
            private Integer id;
        }

        /**
         * Запрос на список продуктов, отфильтрованных
         * по конкретным характеристикам
         */
        @Data
        public static class FilterByFeatures implements GetFeatures {
            private Set<FeatureDTO.Request.Get> featuresFilter;
        }

    }

    public enum Response {;

        /**
         * Предварительная информация о продукте
         * (для вида из каталога)
         */
        @Value
        public static class GetPreview implements Id, Name, Type, Image, Status, BasePrice {
            Integer id;
            String name;
            String type;
            ImageDTO.Response.GetImage image;
            String status;
            Integer basePrice;
        }

        /**
         * Полная информация о продукте
         * (для вида со страницы продукта или конструктора)
         */
        @Value
        public static class GetFull implements Id, Name, Type,
                                    Description, Status, BasePrice,
                                    AdditionalPrice, FullPrice, Features,
                                    UnitsFeatures, ImagesSet {
            Integer id;
            String name;
            String description;
            String type;
            Set<ImageDTO.Response.GetImage> images;
            String status;
            Integer basePrice;
            Integer additionalPrice;
            Integer fullPrice;
            Set<FeatureDTO.Response.GetUnitless> features;
            Set<FeatureDTO.Response.GetWithUnits> unitsFeatures;
        }
    }
}


