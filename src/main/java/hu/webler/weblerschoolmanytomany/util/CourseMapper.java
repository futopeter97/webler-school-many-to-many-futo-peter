package hu.webler.weblerschoolmanytomany.util;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.model.CourseCreateModel;
import hu.webler.weblerschoolmanytomany.model.CourseModel;
import hu.webler.weblerschoolmanytomany.model.CourseUpdateModel;

import java.util.Optional;

public class CourseMapper {

    public static CourseModel mapCourseEntityToCourseModel(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setId(course.getId());
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setStartDate(course.getStartDate());
        courseModel.setEndDate(course.getEndDate());
        courseModel.setSchool(course.getSchool());
        courseModel.setTeacher(course.getTeacher());
        courseModel.setStudents(course.getStudents());
        return courseModel;
    }

    public static Course mapCourseCreateModelToCourseEntity(CourseCreateModel courseCreateModel) {
        Course course = new Course();
        course.setName(courseCreateModel.getName());
        course.setDescription(courseCreateModel.getDescription());
        course.setStartDate(courseCreateModel.getStartDate());
        course.setEndDate(courseCreateModel.getEndDate());
        return course;
    }

    public static void mapCourseUpdateModelToCourseEntity(Course course, CourseUpdateModel courseUpdateModel) {
        Optional.ofNullable(courseUpdateModel.getName()).ifPresent(course::setName);
        Optional.ofNullable(courseUpdateModel.getDescription()).ifPresent(course::setDescription);
        Optional.ofNullable(courseUpdateModel.getStartDate()).ifPresent(course::setStartDate);
        Optional.ofNullable(courseUpdateModel.getEndDate()).ifPresent(course::setEndDate);
    }

    public CourseMapper() {
    }
}
