package allegrocrawler.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by demageron on 20.09.16.
 */
@Data
@Entity
@Table(name = "TimeStamp")
public class TimeStamp {

    @Id
    @SequenceGenerator(name = "timestamp_SQ", sequenceName = "timestampsq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timestamp_SQ")
    private Integer id;

    @Column
    private LocalDateTime timeStamp = LocalDateTime.now();

}
