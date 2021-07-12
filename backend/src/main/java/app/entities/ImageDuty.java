package app.entities;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ImageDuty", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageDuty extends AbstractEntity{
    @NotNull
    @Column
    private String name;
}
