/*
 * Uliana
 */
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

public enum UnitsDTO implements DTO {;
    private interface Id {
        Integer getId();
    }

    private interface Name {
        String getName();
    }

    //TODO я не уверена, нужны ли Units действительные мерки, поэтому просто пока оставлю тут
    private interface Measure {
        Double getMeasure();
    }

    public enum Request {;
        @Data
        public static class ChangeUnits implements Id, Measure {
            private Integer id;
            private Double measure;
        }
    }

    public enum Response {;
        @Value
        public static class Get implements Name, Measure {
            String name;
            Double measure;
        }
    }
}
