package app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "product_id")
    @NotNull
    private Product reviewedProduct;

    @Column
    @NotNull
    private LocalDateTime dateTime;
}
