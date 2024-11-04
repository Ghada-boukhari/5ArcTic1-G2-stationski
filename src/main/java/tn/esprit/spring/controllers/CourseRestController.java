package tn.esprit.spring.controllers;

import org.apache.log4j.Logger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.services.ICourseServices;

import java.util.List;

@Tag(name = "\uD83D\uDCDA Course Management")
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseRestController {
    private static final Logger logger = Logger.getLogger(CourseRestController.class);

    private final ICourseServices courseServices;

    @Operation(description = "Add Course")
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        logger.info("Adding course: " + course); // Log info about adding a course
        return courseServices.addCourse(course);
    }

    @Operation(description = "Retrieve all Courses")
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        logger.info("Retrieving all courses"); // Log info about retrieving all courses
        return courseServices.retrieveAllCourses();
    }

    @Operation(description = "Update Course")
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        logger.info("Updating course: " + course); // Log info about updating a course
        return courseServices.updateCourse(course);
    }

    @Operation(description = "Retrieve Course by Id")
    @GetMapping("/get/{id-course}")
    public Course getById(@PathVariable("id-course") Long numCourse) {
        logger.info("Retrieving course with ID: " + numCourse); // Log info about retrieving a course by ID
        return courseServices.retrieveCourse(numCourse);
    }
}

