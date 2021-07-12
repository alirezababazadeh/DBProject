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
@Table(name = "teacher_courses_average")
public class TeacherCoursesAverage implements Serializable {

    @Id
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "year")
    private Long year;

    @Column(name = "term")
    private Long term;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "average")
    private double average;
}
