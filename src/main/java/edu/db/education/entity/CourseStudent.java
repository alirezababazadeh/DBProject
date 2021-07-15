package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course_student")
public class CourseStudent {
    @Id
    @Column(name = "csid")
    private Long csid;

    @Column(name = "stid")
    private Long stid;

    @Column(name = "cgid")
    private Long cgid;

    @Column(name = "grade")
    private double grade;

}
