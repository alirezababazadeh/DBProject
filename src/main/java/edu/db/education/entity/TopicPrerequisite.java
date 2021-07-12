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
@Table(name = "topic_prerequisite")
public class TopicPrerequisite implements Serializable {

    @Id
    @Column(name = "toid")
    private Long topicId;


    @Column(name = "pre_toid")
    private Long preTopicId;
}
