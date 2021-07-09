package app.controllers.dto;

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
        public static class Get implements Id {
            private Integer id;
        }

        @Data
        public static class SetAmount implements Product, Amount {
            private String product;
            private Integer amount;
        }

        @Data
        public static class SetAmountOnId implements Id, Amount {
            private String id;
            private Integer amount;
        }
    }

    public enum Response {;

        @Value
        public static class GetAmountOnId implements Amount, Id {
            Integer id;
            Integer amount;
        }

        @Value
        public static class GetFullInfo implements Amount, Product {
            Integer amount;
            String product;
        }
    }
}
