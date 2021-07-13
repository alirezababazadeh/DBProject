package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "basic_topic")
public class BasicTopic {

    @Id
    @Column(name = "btid")
    private Long btid;

    @Column(name = "score_share")
    private double score_share;

}
