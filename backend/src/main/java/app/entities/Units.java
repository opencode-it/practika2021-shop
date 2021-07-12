package app.entities;


import com.sun.istack.NotNull;
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
    @NotNull
    @Column
    private String name;

}
