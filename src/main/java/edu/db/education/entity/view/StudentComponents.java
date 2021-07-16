package edu.db.education.entity.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_components")
public class StudentComponents {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "year")
    private Long year;

    @Column(name = "term")
    private Long term;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "component_title")
    private String componentTitle;

    @Column(name = "component_grade")
    private double componentGrade;
}
