package app.enteties;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Units")
@NoArgsConstructor
@AllArgsConstructor
public class Units extends AbstractEntity {

    @Column
    private String name;

}
