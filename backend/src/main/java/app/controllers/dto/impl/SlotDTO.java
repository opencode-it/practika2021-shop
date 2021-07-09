package app.controllers.dto.impl;

import lombok.Data;
import lombok.Value;

public enum SlotDTO {;

    private interface Product {
        String getProduct();
    }

    private interface Amount {
        Integer getAmount();
    }

    public enum Request {;

        @Data
        public static class Get implements Product {
            private String product;
        }

    }

    public enum Response {;

        @Value
        public static class GetAmount implements Amount {
            Integer amount;
        }

    }
}
