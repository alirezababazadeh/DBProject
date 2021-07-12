package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "practice")
public class Practice {

    @Id
    @Column(name = "cmpid")
    private Long componentId;

    @Column(name = "ppd")
    private Long percentPerDay;

    @Column(name = "delay_days")
    private Long delayDays;

    @Column(name = "unit_type")
    private String unitType;

}
