package app.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ImageDuty")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDuty extends AbstractEntity{

    @Column
    private String name;
}
