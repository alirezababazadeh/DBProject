package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "stid")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "field")
    private String field;

}
