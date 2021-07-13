package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "stid")
    private Long stid;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "field")
    private String field;

}
