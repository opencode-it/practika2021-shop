package app.entities;


import javax.persistence.*;

@MappedSuperclass
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
}
