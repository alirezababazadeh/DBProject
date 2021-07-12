package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @Column(name = "cmpid")
    private Long componentId;

    @Column(name = "unit_type")
    private String unitType;
}
