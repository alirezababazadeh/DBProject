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
@Table(name = "component_delivery")
public class ComponentDelivery {
    @Id
    @Column(name = "cdid")
    private Long id;

    @Column(name = "cmpid")
    private Long componentId;

    @Column(name = "csid")
    private Long courseStudentId;

    @Column(name = "grade")
    private double grade;

    @Column(name = "delivery_time")
    private Timestamp deliveryTime;
}
