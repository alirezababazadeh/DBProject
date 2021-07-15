package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "topic_prerequisite")
public class TopicPrerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpid")
    private Long id;

    @Column(name = "toid")
    private Long toid;

    @Column(name = "pre_toid")
    private Long pre_toid;
}
