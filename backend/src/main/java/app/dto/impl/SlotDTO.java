package app.dto.impl;

import app.dto.DTO;
import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

public enum SlotDTO {;

    private interface Id {
        Long getId();
    }

    private interface Product {
        String getProduct();
    }

    private interface Amount {
        Integer getAmount();
    }

    public enum Request {;

        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }

        @Data
        @AllArgsConstructor
        public static class SetAmount implements DTO, Product, Amount, RequestDTO {
            private String product;
            private Integer amount;
        }

        @Data
        @AllArgsConstructor
        public static class SetAmountOnId implements Id, Amount, RequestDTO {
            private Long id;
            private Integer amount;
        }
    }

    public enum Response {;

        @Value
        public static class GetAmountOnId implements Amount, Id, ResponseDTO {
            Long id;
            Integer amount;
        }

        @Value
        public static class GetFullInfo implements Amount, Product, ResponseDTO {
            Integer amount;
            String product;
        }
    }
}
