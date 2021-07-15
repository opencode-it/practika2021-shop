package app.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "Units", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
@NoArgsConstructor
@AllArgsConstructor
public class Units extends AbstractEntity {

    @Column
    private String name;

}
