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
    @Column(name = "comtoid")
    private Long comtoid;

    @Column(name = "toid")
    private Long toid;

    @Column(name = "cmpid")
    private Long cmpid;
}
