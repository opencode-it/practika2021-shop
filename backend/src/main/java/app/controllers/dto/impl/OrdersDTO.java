package app.controllers.dto.impl;

import app.entities.Product;

import java.time.LocalDateTime;
import java.util.List;

public enum OrdersDTO {;

    private interface Account {
        AccountDTO account();
    }

    private interface Products {
        List<Product> products();
    }

    private interface Count {
        Integer count();
    }

    private interface Discount {
        DiscountDTO discount();
    }

    private interface Date {
        LocalDateTime date();
    }

    /**
     * дописать
     * */

    // private interface OrderStatus



}
