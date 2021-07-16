package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.interfaces.filter.CommonFeaturesFilter;
import app.dto.interfaces.filter.PriceFilter;
import app.dto.interfaces.filter.TypeFeatureFilter;
import app.dto.interfaces.filter.TypeFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

public enum FilterProductDTO {;

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
