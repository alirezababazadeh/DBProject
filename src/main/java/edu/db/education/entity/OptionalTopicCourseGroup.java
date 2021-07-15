package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "otcg")
public class OptionalTopicCourseGroup {
    @Id
    @Column(name = "otcgid")
    private Long id;

    @Column(name = "cgid")
    private Long courseGroupId;

    @Column(name = "otid")
    private Long optionalTopicId;

    @Column(name = "score_share")
    private double scoreShare;

}
