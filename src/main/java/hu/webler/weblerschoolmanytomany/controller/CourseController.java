package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.model.CourseUpdateModel;
import hu.webler.weblerschoolmanytomany.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getSchool());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(courseService.findCourseById(id));
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseModel> createCourse(@RequestBody CourseCreateModel courseCreateModel) {
        return ResponseEntity.status(200).body(courseService.createCourse(courseCreateModel));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/courses/{id}")
    public ResponseEntity<CourseModel> updateCourse(@PathVariable Long id,
                                                    @RequestBody CourseUpdateModel courseUpdateModel) {
        return ResponseEntity.status(200).body(courseService.updateCourse(courseUpdateModel, id));
    }
}
