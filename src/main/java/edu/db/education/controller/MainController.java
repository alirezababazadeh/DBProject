package edu.db.education.controller;

import edu.db.education.entity.Student;
import edu.db.education.entity.Teacher;
import edu.db.education.entity.view.StudentComponents;
import edu.db.education.entity.view.StudentCourses;
import edu.db.education.entity.view.TeacherComponentsAverage;
import edu.db.education.repository.*;
import edu.db.education.repository.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
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

    @Autowired
    private StudentComponentsRepository studentComponentsRepository;
    @Autowired
    private StudentCoursesRepository studentCoursesRepository;
    @Autowired
    private StudentTermsAverageRepository studentTermsAverageRepository;
    @Autowired
    private TeacherComponentsAverageRepository teacherComponentsAverageRepository;
    @Autowired
    private TeacherCoursesAverageRepository teacherCoursesAverageRepository;

    @PostMapping
    @Transactional
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

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherByID(@PathVariable(value = "id") Long id) {
        return teacherRepository.findById(id).get();
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentsByID(@PathVariable(value = "id") Long id) {
        return studentRepository.findById(id).get();
    }

    @GetMapping("/teacher-components")
    public List<TeacherComponentsAverage> getTeacherComponentsAverage() {
        return teacherComponentsAverageRepository.findAll();
    }

    @GetMapping("/teachers-components/{id}")
    public TeacherComponentsAverage getTeacherComponentAverageByID(@PathVariable(value = "id") Long id) {
        return teacherComponentsAverageRepository.findById(id).get();
    }

    @GetMapping("/students-components")
    public List<StudentComponents> getStudentComponents() {
        return studentComponentsRepository.findAll();
    }

    @GetMapping("/students-components/{id}")
    public StudentComponents getStudentComponentById(@PathVariable(value = "id") Long id) {
        return studentComponentsRepository.findById(id).get();
    }

    @GetMapping("/students-courses")
    public List<StudentCourses> getStudentCourses() {
        return studentCoursesRepository.findAll();
    }

    @GetMapping("/students-courses/{id}")
    public StudentCourses getStudentCourseByID(@PathVariable(value = "id") Long id) {
        return studentCoursesRepository.findById(id).get();
    }
}
