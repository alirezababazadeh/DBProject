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
@Table(name = "student_terms_average")
public class StudentTermsAverage implements Serializable {

    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "year")
    private Long year;

    @Column(name = "term")
    private Long term;

    @Column(name = "average")
    private double average;

}
