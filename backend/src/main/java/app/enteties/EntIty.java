package app.enteties;


import javax.persistence.*;

@MappedSuperclass
public class EntIty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
}
