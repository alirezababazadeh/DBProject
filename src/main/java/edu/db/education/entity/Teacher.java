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
@Table(name = "teacher")
public class Teacher implements Serializable {
    @Id
    @Column(name = "tchid")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "specialty")
    private String specialty;
}
