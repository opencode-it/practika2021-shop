/*
 * Uliana
 */
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * Содержит енамы классов, отвечающих за
 * запросы и ответы по заказу
 */
public enum OrdersDTO {;

    /**
     * ID аккаунта заказчика
     */
    private interface AccountId {
        Long getAccountId();
    }

    /**
     * ID заказа
     */
    private interface Id {
        Long getId();
    }

    /**
     * Продукты и их количество в заказе
     */
    private interface ProductsId {
        Map<Long, Integer> getOrderedProductIds();
    }


    /**
     * Короткая информация о всех продуктах в заказе
     */
    private interface ProductsInfo {
        Set<ProductDTO.Response.GetOrderedBase> getProductsInOrder();
    }

    /**
     * Дата оформления заказа
     */
    private interface Date {
        LocalDateTime getDate();
    }

    /**
     * Текуший статус заказа
     */
    private interface Status {
        String getStatus();
    }

    private interface Discount {
        Integer getDiscount();
    }

    /**
     * Полная стоимость заказа
     */
    private interface GrandTotal {
        BigDecimal getGrandTotal();
    }

    public enum Request {;

        /**
         * Запрос на получение информации по одному закзу
         */
        @Data
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO {
            private Long id;
        }


        /**
         * Запрос на формирование заказа из товаров в корзине
         */
        @Data
        @AllArgsConstructor
        public static class ConfirmOrder implements AccountId, ProductsId, Discount, RequestDTO {
            private Long accountId;
            private Map<Long, Integer> orderedProductIds;
            private Integer discount;
        }

        /**
         * Чтобы удалить/отменить оформленный заказ
         */
        @Data
        @AllArgsConstructor
        public static class DeleteOrder implements Id, AccountId, ProductsId, Status, RequestDTO {
            private Long id;
            private Long accountId;
            private Map<Long, Integer> orderedProductIds;
            private String status;
        }
    }

    public enum Response {;

        /**
         * Запрос на отображение корзины перед окончательным оформлением заказа в системе
         */
        @Data
        @AllArgsConstructor
        public static class GetFormed implements Id, AccountId, ProductsInfo, GrandTotal, ResponseDTO {
            Long id;
            Long accountId;
            Set<ProductDTO.Response.GetOrderedBase> productsInOrder;
            BigDecimal grandTotal;
        }

        /**
         * Запрос на отображение полной информации о совершенном заказе
         */
        @Data
        @AllArgsConstructor
        public static class GetFull implements Id, AccountId, ProductsInfo, GrandTotal, Date, Status, ResponseDTO {
            Long id;
            Long accountId;
            Set<ProductDTO.Response.GetOrderedBase> productsInOrder;
            BigDecimal grandTotal;
            LocalDateTime date;
            String status;
        }
    }
}
