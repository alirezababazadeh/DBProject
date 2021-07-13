package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "coid")
    private Long coid;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private Long unit;

    @Column(name = "type")
    private String type;
}
