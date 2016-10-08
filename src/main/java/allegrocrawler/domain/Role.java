package allegrocrawler.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by demageron on 05.10.16.
 */
@Entity
@Data
@Table
public class Role {

    @Id
    @SequenceGenerator(name = "role_SQ", sequenceName = "rolesq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_SQ")
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
