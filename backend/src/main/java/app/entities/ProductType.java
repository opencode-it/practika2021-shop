package app.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
public class ProductType extends AbstractEntity{
    @NotNull
    @Column
    private String name;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_ID")
    private List<Feature> prod_feature;

}
