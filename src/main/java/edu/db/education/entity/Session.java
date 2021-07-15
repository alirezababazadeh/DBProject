package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "seid")
    private Long seid;

    @Column(name = "time")
    private String time;

    @Column(name = "cgid")
    private Long cgid;

}
