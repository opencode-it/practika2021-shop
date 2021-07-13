package app.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "product", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity{
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private String desription;
    @NotNull
    @Column
    BigDecimal price;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_ID")
    private List<Image> images;
    @NotNull
    @Column
    private ProductStatus prodStatus;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_ID")
    private ProductType type;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "feature_ID")
    private List<ProductFeature> features;
}
