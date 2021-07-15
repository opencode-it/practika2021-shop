package app.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Visit extends AbstractEntity {

    @ManyToOne()
    private Account account;

    @ManyToOne()
    private Product reviewedProduct;

    @NotNull
    @Column
    private LocalDateTime dateTime;
}
