package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "tchid")
    private Long tchid;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "specialty")
    private String specialty;
}
