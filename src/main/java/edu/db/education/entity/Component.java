package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "component")
public class Component {
    @Id
    @Column(name = "cmpid")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cgid")
    private Long courseGroupId;

    @Column(name = "grade")
    private double grade;

    @Column(name = "release_date")
    private Timestamp releaseDate;

    @Column(name = "finish_date")
    private Timestamp finishDate;
}
