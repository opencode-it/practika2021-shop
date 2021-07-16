package app.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "productFeature")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeature extends AbstractEntity{

    @PrimaryKeyJoinColumn(name = "feture_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Feature feature;

    @PrimaryKeyJoinColumn(name = "product_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @Column
    private String value;

    @Column
    private Integer additionalPrice;

}
