package edu.db.education.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "optional_topic")
public class OptionalTopic {

    @Id
    @Column(name = "otid")
    private Long id;
}
