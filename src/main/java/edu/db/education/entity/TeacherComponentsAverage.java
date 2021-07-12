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
@Table(name = "teacher_components_average")
public class TeacherComponentsAverage implements Serializable {

    @Id
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "year")
    private Long year;

    @Column(name = "term")
    private Long term;

    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "component_title")
    private String componentTitle;

    @Column(name = "average")
    private double average;
}
