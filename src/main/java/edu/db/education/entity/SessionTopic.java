package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "session_topic")
public class SessionTopic {
    @Id
    @Column(name = "st_id")
    private Long id;

    @Column(name = "seid")
    private Long seid;

    @Column(name = "toid")
    private Long toid;

    @Override
    public String toString() {
        return "SessionTopic{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", topicId=" + topicId +
                '}';
    }
}
