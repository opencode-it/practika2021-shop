package app.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
public class ProductType extends AbstractEntity{

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_ID")
    private Set<Feature> prod_feature;

}
