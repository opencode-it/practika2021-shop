package app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Visit extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product reviewedProduct;

    @Column
    private LocalDateTime dateTime;
}
