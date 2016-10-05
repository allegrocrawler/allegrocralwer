package allegrocrawler.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by demageron on 05.10.16.
 */
@Entity
@Data
@Table
public class UserDefinition {

    @OneToMany
    List<UserRole> roles;
    @Id
    @SequenceGenerator(name = "user_SQ", sequenceName = "usersq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_SQ")
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;

}
