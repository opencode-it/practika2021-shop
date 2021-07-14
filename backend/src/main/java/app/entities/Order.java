package app.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbstractEntity {
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "accounts_ID")
    private Account account;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_ID")
    private Discount discount;
    @NotNull
    @PrimaryKeyJoinColumn(name = "order_has_product_ID")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrdersProducts> ordersProducts;
    @NotNull
    @Column(name = "date")
    private LocalDateTime date;
    @NotNull
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
