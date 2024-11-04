package tn.esprit.spring.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse; // Assurez-vous que cette importation est présente
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CourseServicesImplTest {
 private static final Logger log = LoggerFactory.getLogger(CourseServicesImpl.class);
    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private CourseServicesImpl courseServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllCourses() {
        Course course1 = new Course(1L, "Course1", TypeCourse.SCIENCE);
        Course course2 = new Course(2L, "Course2", TypeCourse.LANGUAGE);

        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        List<Course> courses = courseServices.retrieveAllCourses();

        assertEquals(2, courses.size());
        assertEquals("Course1", courses.get(0).getName());
    }

    @Test
    void testAddCourse() {
        Course course = new Course(1L, "Course1", TypeCourse.SCIENCE);

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseServices.addCourse(course);

        assertNotNull(result);
        assertEquals("Course1", result.getName());
    }

    @Test
    void testUpdateCourse() {
        Course course = new Course(1L, "UpdatedCourse", TypeCourse.SCIENCE);

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseServices.updateCourse(course);

        assertNotNull(result);
        assertEquals("UpdatedCourse", result.getName());
    }

    @Test
    void testRetrieveCourse() {
        Course course = new Course(1L, "Course1", TypeCourse.SCIENCE);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course result = courseServices.retrieveCourse(1L);

        assertNotNull(result);
        assertEquals("Course1", result.getName());
    }
}

