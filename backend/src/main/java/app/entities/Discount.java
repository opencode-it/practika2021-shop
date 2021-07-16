package app.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "discount", uniqueConstraints= @UniqueConstraint(columnNames={"value"}))
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Discount extends AbstractEntity {

    @Column(name = "value")
    private Integer value;
}
