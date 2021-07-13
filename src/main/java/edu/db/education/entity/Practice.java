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
    private Long cmpid;

    @Column(name = "ppd")
    private Long ppd;

    @Column(name = "delay_days")
    private Long delay_days;

    @Column(name = "unit_type")
    private String unit_type;

}
