/*
 * Uliana
 */
package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
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
        Long getId();
    }

    private interface AccountId {
        Long getAccountId();
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
    private interface FeaturesRequests {
        Set<FeatureDTO.Request.Get> getRequestedFeatures();
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
        Set<ImageDTO.Response.GetImage> getImagesSet();
    }

    /**
     * Все доступные изображения продукта
     */
    private interface LoadedImagesSet {
        Set<ImageDTO.Request.Get> getImages();
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

    private interface Amount {
        Integer getAmount();
    }

    public enum Request {;

        /**
        * Запрос на продукт по его ID
        */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }

        @Data
        @AllArgsConstructor
        public static class GetTypedAll implements AccountId, Type, RequestDTO {
            private String type;
            private Long accountId;
        }

        @Data
        @AllArgsConstructor
        public static class GetForAccount implements AccountId, RequestDTO {
            private Long accountId;
        }



        @Data
        @AllArgsConstructor
        public static class CreateProduct implements Name, Description, Type,
                                                     FeaturesRequests, LoadedImagesSet,
                                                     BasePrice, RequestDTO {
            private String name;
            private String description;
            private String type;
            private Set<FeatureDTO.Request.Get> requestedFeatures;
            private Set<ImageDTO.Request.Get> images;
            private BigDecimal basePrice;
        }

        @Data
        @AllArgsConstructor
        public static class EditProduct implements Id, Name, Description,
                                                   FeaturesRequests, LoadedImagesSet,
                                                   BasePrice, RequestDTO {
            private Long id;

            private String name;
            private boolean isNewName;

            private String description;
            private boolean isNewDescription;

            private Set<FeatureDTO.Request.Get> requestedFeatures;
            private boolean isNewFeatures;

            private Set<ImageDTO.Request.Get> images;
            private boolean newImages;

            private BigDecimal basePrice;
            private boolean isNewPrice;
        }

    }

    public enum Response {;

        /**
         * Предварительная информация о продукте
         * (для вида из каталога)
         */
        @Value
        public static class GetBase implements Id, Name, Type, Image, Status, BasePrice, ResponseDTO {
            Long id;
            String name;
            String type;
            ImageDTO.Response.GetImage image;
            String status;
            BigDecimal basePrice;
        }

        /**
         * Полная информация о продукте
         * (для вида со страницы продукта или конструктора)
         */
        @Data
        @AllArgsConstructor
        public static class GetFull implements Id, Name, Type,
                                    Description, Status, BasePrice,
                                    AdditionalPrice, FullPrice, Features,
                                    UnitsFeatures, ImagesSet, ResponseDTO {
            Long id;
            String name;
            String description;
            String type;
            Set<ImageDTO.Response.GetImage> imagesSet;
            String status;
            BigDecimal basePrice;
            BigDecimal additionalPrice;
            BigDecimal fullPrice;
            Set<FeatureDTO.Response.GetUnitless> features;
            Set<FeatureDTO.Response.GetWithUnits> unitsFeatures;
        }

        @Data
        public static class GetOrderedBase implements Id, Name, Type, Image, BasePrice, Amount, ResponseDTO {
            Long id;
            String name;
            String type;
            ImageDTO.Response.GetImage image;
            Integer amount;
            BigDecimal basePrice;
        }
    }
}


