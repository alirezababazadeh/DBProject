package edu.db.education.controller;

import edu.db.education.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class EducationSystemController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private BasicTopicRepository basicTopicRepository;
    @Autowired
    private OptionalTopicRepository optionalTopicRepository;
    @Autowired
    private TopicPrerequisiteRepository topicPrerequisiteRepository;
    @Autowired
    private CourseGroupRepository courseGroupRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private SessionTopicRepository sessionTopicRepository;
    @Autowired
    private OptionalTopicCourseGroupRepository optionalTopicCourseGroupRepository;
    @Autowired
    private CourseStudentRepository courseStudentRepository;
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ComponentDeliveryRepository componentDeliveryRepository;
    @Autowired
    private ComponentTopicRepository componentTopicRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private PracticeRepository practiceRepository;

    @PostMapping("register")
    public void register(@RequestBody Registration registration) {
        registration.getTeachers().forEach(teacher -> teacherRepository.save(teacher));
        registration.getStudents().forEach(student -> studentRepository.save(student));
        registration.getCourses().forEach(course -> courseRepository.save(course));
        registration.getTopics().forEach(topic -> topicRepository.save(topic));
        registration.getBasicTopics().forEach(basicTopic -> basicTopicRepository.save(basicTopic));
        registration.getOptionalTopics().forEach(optionalTopic -> optionalTopicRepository.save(optionalTopic));
        registration.getTopicPrerequisites().forEach(topicPrerequisite -> topicPrerequisiteRepository.save(topicPrerequisite));
        registration.getCourseGroups().forEach(courseGroup -> courseGroupRepository.save(courseGroup));
        registration.getSessions().forEach(session -> sessionRepository.save(session));
        registration.getSessionTopics().forEach(sessionTopic -> sessionTopicRepository.save(sessionTopic));
        registration.getOptionalTopicCourseGroups().forEach(optionalTopicCourseGroup -> optionalTopicCourseGroupRepository.save(optionalTopicCourseGroup));
        registration.getCourseStudents().forEach(courseStudent -> courseStudentRepository.save(courseStudent));
        registration.getComponents().forEach(component -> componentRepository.save(component));
        registration.getComponentDeliveries().forEach(componentDelivery -> componentDeliveryRepository.save(componentDelivery));
        registration.getComponentTopics().forEach(componentTopic -> componentTopicRepository.save(componentTopic));
        registration.getExams().forEach(exam -> examRepository.save(exam));
        registration.getPractices().forEach(practice -> practiceRepository.save(practice));
    }
}
