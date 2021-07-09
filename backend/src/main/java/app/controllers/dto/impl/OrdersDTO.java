/*
* Uliana
*/
package app.controllers.dto.impl;

import app.controllers.dto.DTO;
import lombok.Data;
import lombok.Value;

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
        Integer getAccountId();
    }

    /**
     * ID заказа
     */
    private interface Id {
        Integer getId();
    }

    /**
     * Продукты и их количество в заказе
     */
    private interface ProductsId {
        Map<Integer, Integer> getOrderedProductIds();
    }

    /**
     * Для обращения к одному продукту в заказе
     */
    private interface Product {
        Integer getProductId();
    }

    /**
     * Короткая информация о всех продуктах в заказе
     */
    private interface ProductsInfo {
        Set<ProductDTO.Response.GetBase> getProductsInOrder();
    }

    /**
     * Примененная скидка к заказу
     */
    private interface Discount {
        Integer getDiscount();
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
        public static class Get implements DTO, Id {
            private Integer id;
        }

        /**
         * Запрос на уменьшение конкретного продукта в заказе на одну единицу
         */
        @Data
        public static class DecreaseProductAmount implements DTO, Id, Product {
            private Integer Id;
            private Integer productId;
        }

        /**
         * Запрос на увеличение конкретного продукта в заказе на одну единицу
         */
        @Data
        public static class IncreaseProductAmount implements DTO, Id, Product {
            private Integer Id;
            private Integer productId;
        }

        /**
         * Запрос на применение скидки к заказу
         */
        @Data
        public static class ApplyDiscount implements DTO, Id, Discount {
            //TODO и че с этим делать
        }

        /**
         * Запрос на формирование заказа из товаров в корзине
         */
        @Data
        public static class ConfirmOrder implements DTO, AccountId, ProductsId {
            private Integer accountId;
            private Map<Integer, Integer> orderedProductIds;
        }
    }

    public enum Response {;

        /**
        * Запрос на отображение корзины перед окончательным оформлением заказа в системе
        */
        @Value
        public static class GetFormed implements DTO, Id, AccountId, ProductsInfo, GrandTotal {
            Integer id;
            Integer accountId;
            Set<ProductDTO.Response.GetBase> productsInOrder;
            BigDecimal grandTotal;
        }

        /**
         * Запрос на отображение полной информации о совершенном заказе
         */
        @Value
        public static class GetFull implements DTO, Id, AccountId, ProductsInfo, GrandTotal, Date, Status {
            Integer id;
            Integer accountId;
            Set<ProductDTO.Response.GetBase> productsInOrder;
            BigDecimal grandTotal;
            LocalDateTime date;
            String status;
        }
    }
}
