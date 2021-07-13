package app.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_has_products")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrdersPorducts extends AbstractEntity{
    @NotNull
    @PrimaryKeyJoinColumn(name = "product_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @NotNull
    @PrimaryKeyJoinColumn(name = "order_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
    @NotNull
    @Column
    private Integer count;
}
