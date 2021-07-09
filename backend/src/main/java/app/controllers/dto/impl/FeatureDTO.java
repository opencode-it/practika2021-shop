/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

public enum FeatureDTO implements DTO {;
    private interface Id {
        Integer getId();
    }

    private interface Name {
        String getName();
    }

    private interface Units {
        UnitsDTO.Response.Get getUnits();
    }

    private interface Value {

    }

    private interface FeaturePrice {
        Integer getFeaturePrice();
    }

    public enum Request {;

        @Data
        public static class Get implements Id {
            private Integer id;
        }

        @Data
        public static class


    }

    public enum Response {;
        @Value
        public static class GetWithUnits implements Name, FeaturePrice, Units {
            String name;
            UnitsDTO.Response.Get units;
            Integer featurePrice;
        }

        @Value
        public static class Get implements Name, FeaturePrice {
            String name;
            Integer featurePrice;
        }

    }


}
