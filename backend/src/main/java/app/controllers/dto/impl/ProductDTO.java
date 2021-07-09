/*
* Uliana
*/
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;

import java.math.BigDecimal;

import java.util.Map;

public enum ProductDTO implements DTO {;

    private interface Id {
        Integer getId();
    }

    private interface Description {
        String getDescription();
    }

    private interface Type {
        String getType();
        Map<String, String> getFeaturesUnits();
    }

    private interface ImageUrl {
        String getUrl();
    }

    private interface ImageDuty {
        String getDuty();
    }

    private interface AdditionalPrice {
        BigDecimal getAdditionalPrice();
    }

    private interface BasePrice {
        BigDecimal getBasePrice();
    }

    private interface FullPrice {
        BigDecimal getFullPrice();
    }

    private interface Status {
        String getStatus();
    }

    public enum Request {;
        @Data
        public static class Get implements Id {
            private Integer id;
        }
    }

    public enum Response {;

    }

}
