package app.controllers.dto.impl;

import app.entities.Product;

import java.time.LocalDateTime;
import java.util.List;

public enum OrdersDTO {;

    private interface Account {
        AccountDTO.Request.Get getAccount();
    }

 //   private interface Products

    private interface Count {
        Integer getCount();
    }
/*

    private interface Discount {
        DiscountDTO getDiscount();
    }
*/

    private interface Date {
        LocalDateTime getDate();
    }

    /**
     * дописать
     * */

    // private interface OrderStatus



}
