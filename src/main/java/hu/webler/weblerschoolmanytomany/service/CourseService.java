package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.model.CourseUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.CourseRepository;
import hu.webler.weblerschoolmanytomany.util.CourseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseModel> getSchool() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::mapCourseEntityToCourseModel)
                .collect(Collectors.toList());
    }

    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id)
                .orElseThrow(() -> {
                    String message = String.format("Course with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public CourseModel createCourse(CourseCreateModel courseCreateModel) {
        return CourseMapper.mapCourseEntityToCourseModel(courseRepository
                .save(CourseMapper.mapCourseCreateModelToCourseEntity(courseCreateModel)));
    }

    public void deleteCourse(Long id) {
        findCourseById(id);
        courseRepository.deleteById(id);
    }

    public CourseModel updateCourse(CourseUpdateModel courseUpdateModel, Long id) {
        Course course = findCourseById(id);
        CourseMapper.mapCourseUpdateModelToCourseEntity(course, courseUpdateModel);
        course = courseRepository.save(course);
        return CourseMapper.mapCourseEntityToCourseModel(course);
    }
}
