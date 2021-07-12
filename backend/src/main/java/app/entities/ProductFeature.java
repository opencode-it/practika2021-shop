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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feture_ID")
    private Feature feature;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_ID")
    private Product product;

    @Column
    private String value;

    @Column
    private Integer additionalPrice;

}
