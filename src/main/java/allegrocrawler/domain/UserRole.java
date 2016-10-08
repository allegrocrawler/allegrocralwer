package allegrocrawler.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by demageron on 08.10.16.
 */
@Entity
@Data
public class UserRole implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "userrole_SQ", sequenceName = "userrolesq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userrole_SQ")
    private Integer id;

    @ManyToOne
    private UserDefinition userDefinition;

    @ManyToOne
    private Role role;

    @Override
    public String getAuthority() {
        return role == null ? null : role.getRole().toString();
    }
}
