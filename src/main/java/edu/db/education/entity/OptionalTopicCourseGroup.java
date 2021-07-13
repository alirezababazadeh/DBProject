package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "otcg")
public class OptionalTopicCourseGroup {

    @Id
    @Column(name = "otcgid")
    private Long otcgid;

    @Column(name = "cgid")
    private Long cgid;

    @Column(name = "otid")
    private Long otid;

    @Column(name = "score_share")
    private double score_share;
}
