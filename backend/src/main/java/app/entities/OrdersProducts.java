package app.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_has_products")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrdersProducts extends AbstractEntity{
    @NotNull
    @PrimaryKeyJoinColumn(name = "product_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @NotNull
    @Column
    private Integer count;
}
