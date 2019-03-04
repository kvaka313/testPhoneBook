package ua.galkin.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "phone_book_users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneBookRecord> phoneBookRecords = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
