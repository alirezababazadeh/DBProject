package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course_group")
public class CourseGroup {
    @Id
    @Column(name = "cgid")
    private Long cgid;

    @Column(name = "tchid")
    private Long tchid;

    @Column(name = "coid")
    private Long coid;

    @Column(name = "year")
    private Long year;

    @Column(name = "term")
    private Long term;

}
