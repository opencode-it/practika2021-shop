package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
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
        public static class Get implements Id, RequestDTO {
            private Integer id;
        }

        @Data
        public static class SetAmount implements DTO, Product, Amount, RequestDTO {
            private String product;
            private Integer amount;
        }

        @Data
        public static class SetAmountOnId implements Id, Amount, RequestDTO {
            private String id;
            private Integer amount;
        }
    }

    public enum Response {;

        @Value
        public static class GetAmountOnId implements Amount, Id, ResponseDTO {
            Integer id;
            Integer amount;
        }

        @Value
        public static class GetFullInfo implements Amount, Product, ResponseDTO {
            Integer amount;
            String product;
        }
    }
}
