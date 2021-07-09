package app.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Feature")
@Data
@EqualsAndHashCode(callSuper = true)
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
