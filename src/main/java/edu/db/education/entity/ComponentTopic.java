package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "component_topic")
public class ComponentTopic {
    @Id
    @Column(name = "ct_id")
    private Long id;

    @Column(name = "toid")
    private Long topicId;

    @Column(name = "cmpid")
    private Long componentId;
}
