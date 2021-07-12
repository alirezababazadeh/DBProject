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
@Table(name = "component_topic")
public class ComponentTopic implements Serializable {
    @Id
    @Column(name = "toid")
    private Long topicId;

    @Column(name = "cmpid")
    private Long componentId;
}
