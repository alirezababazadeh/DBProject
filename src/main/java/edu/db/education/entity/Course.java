package edu.db.education.entity;

import edu.db.education.type.CourseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 11)
    private CourseType type;

}
