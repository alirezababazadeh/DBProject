package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "session_topic")
public class SessionTopic implements Serializable {
    @Id
    @Column(name = "seid")
    private Long seid;

    @Column(name = "toid")
    private Long toid;

}
