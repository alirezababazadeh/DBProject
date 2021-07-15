package edu.db.education.entity;

import edu.db.education.type.PracticeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "practice")
public class Practice {
    @Id
    @Column(name = "cmpid")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type")
    private PracticeType unitType;

    @Column(name = "ppd")
    private Long ppd;

    @Column(name = "delay_days")
    private Long delayDays;
}
