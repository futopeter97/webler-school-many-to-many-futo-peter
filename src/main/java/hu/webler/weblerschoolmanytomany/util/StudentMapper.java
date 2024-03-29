package hu.webler.weblerschoolmanytomany.util;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.StudentUpdateModel;

import java.util.Optional;

public class StudentMapper {

    public static StudentModel mapStudentEntityToStudentModel (Student student) {
        StudentModel studentModel = new StudentModel();
        studentModel.setId(student.getId());
        studentModel.setFirstName(student.getFirstName());
        studentModel.setMidName(student.getMidName());
        studentModel.setLastName(student.getLastName());
        studentModel.setEmail(student.getEmail());
        studentModel.setPhone(student.getPhone());
        studentModel.setDateOfBirth(student.getDateOfBirth());
        studentModel.setCourses(student.getCourses());
        return studentModel;
    }

    public static Student mapStudentCreateModelToStudentEntity(StudentCreateModel studentCreateModel) {
        Student student = new Student();
        student.setFirstName(studentCreateModel.getFirstName());
        student.setMidName(studentCreateModel.getMidName());
        student.setLastName(studentCreateModel.getLastName());
        student.setEmail(studentCreateModel.getEmail());
        student.setPhone(studentCreateModel.getPhone());
        student.setDateOfBirth(studentCreateModel.getDateOfBirth());
        return student;
    }

    public static void mapStudentUpdateModelToStudentEntity(Student student, StudentUpdateModel studentUpdateModel) {
        Optional.ofNullable(studentUpdateModel.getFirstName()).ifPresent(student::setFirstName);
        Optional.ofNullable(studentUpdateModel.getMidName()).ifPresent(student::setMidName);
        Optional.ofNullable(studentUpdateModel.getLastName()).ifPresent(student::setLastName);
        Optional.ofNullable(studentUpdateModel.getEmail()).ifPresent(student::setEmail);
        Optional.ofNullable(studentUpdateModel.getPhone()).ifPresent(student::setPhone);
        Optional.ofNullable(studentUpdateModel.getStatus()).ifPresent(student::setStatus);
        Optional.ofNullable(studentUpdateModel.getCourses()).ifPresent(student::setCourses);
    }

    public StudentMapper() {
    }
}
