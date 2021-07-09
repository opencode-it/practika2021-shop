package app.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ImageDuty")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDuty extends AbstractEntity{

    @Column
    private String name;
}
