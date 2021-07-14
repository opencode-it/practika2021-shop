/*
* Uliana
*/
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import lombok.AllArgsConstructor;
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
        @AllArgsConstructor
        public static class Get implements Id, RequestDTO  {
            private Integer id;
        }

        /**
         * Запрос на изменение количества
         * конкретного продукта в заказе на одну единицу
         */
        @Data
        @AllArgsConstructor
        public static class ChangeProductAmount implements Id, Product, RequestDTO  {
            private Integer Id;
            private Integer productId;
            private boolean increase;
        }


        /**
         * Запрос на применение скидки к заказу
         */
        /*@Data
        public static class ApplyDiscount implements Id, Discount, RequestDTO  {
            //TODO и че с этим делать
        }*/

        /**
         * Запрос на формирование заказа из товаров в корзине
         */
        @Data
        @AllArgsConstructor
        public static class ConfirmOrder implements AccountId, ProductsId, RequestDTO {
            private Integer accountId;
            private Map<Integer, Integer> orderedProductIds;
        }

        /**
         * Чтобы удалить/отменить оформленный заказ
         */
        @Data
        @AllArgsConstructor
        public static class DeleteOrder implements Id, AccountId, ProductsId, Status, RequestDTO {
            private Integer id;
            private Integer accountId;
            private Map<Integer, Integer> orderedProductIds;
            private String status;
        }
    }

    public enum Response {;

        /**
        * Запрос на отображение корзины перед окончательным оформлением заказа в системе
        */
        @Value
        public static class GetFormed implements Id, AccountId, ProductsInfo, GrandTotal, ResponseDTO {
            Integer id;
            Integer accountId;
            Set<ProductDTO.Response.GetBase> productsInOrder;
            BigDecimal grandTotal;
        }

        /**
         * Запрос на отображение полной информации о совершенном заказе
         */
        @Value
        public static class GetFull implements Id, AccountId, ProductsInfo, GrandTotal, Date, Status, ResponseDTO {
            Integer id;
            Integer accountId;
            Set<ProductDTO.Response.GetBase> productsInOrder;
            BigDecimal grandTotal;
            LocalDateTime date;
            String status;
        }
    }
}
