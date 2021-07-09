package app.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Feature")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feature extends AbstractEntity{
    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_ID")
    private Units unit;

}
