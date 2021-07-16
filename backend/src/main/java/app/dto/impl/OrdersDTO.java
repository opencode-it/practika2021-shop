/*
 * Uliana
 */
package app.dto.impl;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.dto.interfaces.AccountId;
import app.dto.interfaces.Id;
import app.dto.interfaces.order.Date;
import app.dto.interfaces.order.Discount;
import app.dto.interfaces.order.GrandTotal;
import app.dto.interfaces.order.ProductsId;
import app.dto.interfaces.order.ProductsInfo;
import app.dto.interfaces.order.Status;
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
