package app.entities;

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
public class OrdersProducts extends AbstractEntity{

    @PrimaryKeyJoinColumn(name = "product_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @Column
    private Integer count;
}
