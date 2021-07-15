package app.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image", uniqueConstraints= @UniqueConstraint(columnNames={"path"}))
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends AbstractEntity{
    @Column
    String path;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_duty_id")
    ImageDuty duty;
}