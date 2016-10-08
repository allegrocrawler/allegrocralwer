package allegrocrawler.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by demageron on 08.10.16.
 */
@Entity
@Data
public class UserRole {

    @Id
    @SequenceGenerator(name = "userrole_SQ", sequenceName = "userrolesq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userrole_SQ")
    private Integer id;

    @ManyToOne
    private UserDefinition userDefinition;

    @ManyToOne
    private Role role;

}
