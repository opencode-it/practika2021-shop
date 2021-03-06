package app.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Builder
@Data
@Table(name = "product", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity{

    @Column
    private String name;

    @Column
    private String desription;

    @Column
    BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_ID")
    private Set<Image> images;

    @Column
    private ProductStatus prodStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_ID")
    private ProductType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "feature_ID")
    private Set<ProductFeature> features;
}
