/*
 * Uliana
 */
package app.dto.impl;

import app.dto.DTO;
import app.dto.NeedsRecommendationsDTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.Id;
import app.dto.interfaces.Name;
import app.dto.interfaces.order.Status;
import app.dto.interfaces.product.AdditionalPrice;
import app.dto.interfaces.product.Amount;
import app.dto.interfaces.product.BasePrice;
import app.dto.interfaces.product.Description;
import app.dto.interfaces.product.Features;
import app.dto.interfaces.product.FeaturesRequests;
import app.dto.interfaces.product.FullPrice;
import app.dto.interfaces.product.Image;
import app.dto.interfaces.product.ImagesSet;
import app.dto.interfaces.product.LoadedImagesSet;
import app.dto.interfaces.product.ProductId;
import app.dto.interfaces.product.Type;
import app.dto.interfaces.product.UnitsFeatures;
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

    public enum Request {;

        //TODO в помойку
        @Data
        @AllArgsConstructor
        @Deprecated(forRemoval = true)
        public static class Get implements Id, RequestDTO {
            private Long id;
        }

        /**
         * Передавать id аккаунта на сервер, чтобы при ответе
         * тот мог выдать рекомендованные товары
         */
        @Data
        @AllArgsConstructor
        public static class GetAll implements NeedsRecommendationsDTO {
            private Long accountId;
        }

        /**
         * Передает id аккаунта на сервер и запрашиваемую
         * страницу категории товаров, чтобы выдать
         * рекомендации внутри категории
         */
        @Data
        @AllArgsConstructor
        public static class GetTypeAll implements Type, NeedsRecommendationsDTO {
            private String type;
            private Long accountId;
        }

        /**
         * Запоминает конкретно просмотренные пользователем продукт,
         * чтобы использовать его в дальнейших рекомендациях
         */
        @Data
        @AllArgsConstructor
        public static class GetForAccount implements ProductId, NeedsRecommendationsDTO {
            private Long accountId;
            private Long productId;
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


