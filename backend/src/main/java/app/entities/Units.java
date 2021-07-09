package app.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@Data
@Table(name = "Units")
@NoArgsConstructor
@AllArgsConstructor
public class Units extends AbstractEntity {

    @Column
    private String name;

}
