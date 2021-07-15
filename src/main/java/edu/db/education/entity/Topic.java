package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @Column(name = "toid")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "coid")
    private Long courseId;

}
