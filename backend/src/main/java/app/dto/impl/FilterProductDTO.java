package app.dto.impl;

import app.dto.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

public enum FilterProductDTO {;
    /**
     * Для фильтрации общего списка продуктов
     * по конкретным характеристикам
     */
    private interface CommonFeaturesFilter {
        Set<FeatureDTO.Request.Get> getCommonFeatures();
    }

    private interface TypeFilter {
        String getProductType();
    }

    private interface TypeFeatureFilter {
        Set<FeatureDTO.Request.Get> getTypeFeatures();
    }

    private interface PriceFilter {
        BigDecimal getMinPrice();
        BigDecimal getMaxPrice();
    }


    public enum Request {;
        /**
         * Запрос на список продуктов, отфильтрованных
         * по конкретным характеристикам
         */
        @Data
        @AllArgsConstructor
        public static class FilterByCommonFeatures implements CommonFeaturesFilter, PriceFilter, RequestDTO {
            private Set<FeatureDTO.Request.Get> commonFeatures;
            private BigDecimal minPrice;
            private BigDecimal maxPrice;
        }

        /**
         * Запрос фильтрации продуктов конкретного типа по
         * специфичным для него характеристикам
         */
        @Data
        @AllArgsConstructor
        public static class FilterByTypeFeatures implements TypeFilter, TypeFeatureFilter,
                                                            CommonFeaturesFilter, PriceFilter, RequestDTO {
            private Set<FeatureDTO.Request.Get> commonFeatures;
            private String productType;
            private Set<FeatureDTO.Request.Get> typeFeatures;
            private BigDecimal minPrice;
            private BigDecimal maxPrice;
        }

    }

}
