package edu.db.education.entity;

import edu.db.education.type.ExamType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "cmpid")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type")
    private ExamType unitType;
}
