package app.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts", uniqueConstraints= @UniqueConstraint(columnNames={"token", "email"}))
@Data
@Builder
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

    public static Account guest() {
        return Account.builder()
                .fullName("Guest")
                .build();
    }
}
