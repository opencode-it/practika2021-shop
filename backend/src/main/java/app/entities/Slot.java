package app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "slot")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Slot extends AbstractEntity{

    @Column
    private int amount;

    @OneToOne(cascade = CascadeType.ALL)
    @Column
    Product product;
}
