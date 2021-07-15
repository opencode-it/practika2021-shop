package app.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts", uniqueConstraints= @UniqueConstraint(columnNames={"token", "email"}))
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Account extends AbstractEntity {

    @NotNull
    @Column(name = "token")
    private String token;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rights_ID")
    private Rights rights;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "fullname")
    private String fullName;

    @NotNull
    @Column(name = "googleName")
    private String googleName;

    @NotNull
    @Column(name = "googleUsername")
    private String googleUsername;
}
