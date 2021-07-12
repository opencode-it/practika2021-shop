package app.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "productFeature")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeature extends AbstractEntity{
    @NotNull
    @PrimaryKeyJoinColumn(name = "feture_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Feature feature;
    @NotNull
    @PrimaryKeyJoinColumn(name = "product_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @NotNull
    @Column
    private String value;
    @NotNull
    @Column
    private Integer additionalPrice;

}
