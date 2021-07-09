package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

public enum SlotDTO {;

    private interface Id {
        Integer getId();
    }

    private interface Product {
        String getProduct();
    }

    private interface Amount {
        Integer getAmount();
    }

    public enum Request {;

        @Data
        public static class Get implements DTO, Id {
            private Integer id;
        }

        @Data
        public static class SetAmount implements DTO, Product, Amount {
            private String product;
            private Integer amount;
        }

        @Data
        public static class SetAmountOnId implements DTO, Id, Amount {
            private String id;
            private Integer amount;
        }
    }

    public enum Response {;

        @Value
        public static class GetAmountOnId implements DTO, Amount, Id {
            Integer id;
            Integer amount;
        }

        @Value
        public static class GetFullInfo implements DTO, Amount, Product {
            Integer amount;
            String product;
        }
    }
}
