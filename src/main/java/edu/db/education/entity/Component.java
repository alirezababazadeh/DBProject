package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
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
    private Date releaseDate;

    @Column(name = "finish_date")
    private Date finishDate;

}
