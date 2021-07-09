package app.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {
    WAITING_FOR_PAYMENT,
    PAID,
    DELIVERING,
    DELIVERED;
}
