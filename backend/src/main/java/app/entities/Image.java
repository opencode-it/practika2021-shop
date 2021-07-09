package app.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image")
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
