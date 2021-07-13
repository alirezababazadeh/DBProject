package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "component_delivery")
public class ComponentDelivery {
    @Id
    @Column(name = "cdid")
    private Long cdid;

    @Column(name = "cmpid")
    private Long cmpid;

    @Column(name = "csid")
    private Long csid;

    @Column(name = "grade")
    private double grade;

    @Column(name = "delivery_time")
    private Date delivery_time;
}
