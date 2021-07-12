package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "course_student")
public class CourseStudent {
    @Id
    @Column(name = "csid")
    private Long id;

    @Column(name = "stid")
    private Long studentId;

    @Column(name = "cgid")
    private Long courseGroupId;

    @Column(name = "grade")
    private double grade;

}
