package edu.db.education.controller;

import edu.db.education.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Registration {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;
    private List<Topic> topics;
    private List<BasicTopic> basicTopics;
    private List<OptionalTopic> optionalTopics;
    private List<TopicPrerequisite> topicPrerequisites;
    private List<CourseGroup> courseGroups;
    private List<Session> sessions;
    private List<SessionTopic> sessionTopics;
    private List<OptionalTopicCourseGroup> optionalTopicCourseGroups;
    private List<CourseStudent> courseStudents;
    private List<Component> components;
    private List<ComponentDelivery> componentDeliveries;
    private List<ComponentTopic> componentTopics;
    private List<Exam> exams;
    private List<Practice> practices;
}
