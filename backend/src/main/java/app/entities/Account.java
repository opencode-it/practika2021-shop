package app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AbstractEntity {

    @Column(name = "token")
    private String token;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rights_ID")
    private Rights rights;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "fullname")
    private String fullName;
}
