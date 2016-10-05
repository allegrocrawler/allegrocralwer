package allegrocrawler.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by demageron on 05.10.16.
 */
@Entity
@Data
@Table
public class UserRole {

    @Id
    @SequenceGenerator(name = "userrole_SQ", sequenceName = "userrolesq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userrole_SQ")
    private Integer id;

    @Column
    private String role;
}
