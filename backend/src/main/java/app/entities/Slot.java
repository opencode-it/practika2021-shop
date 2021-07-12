package app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * @author ZubchenkoArtem
 * */
@Entity
@Table(name = "slot")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Slot extends AbstractEntity{

    @Column
    private Integer amount;

    @OneToOne(cascade = CascadeType.ALL)
    Product product;
}
