package hu.webler.weblerschoolmanytomany.util;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;
import hu.webler.weblerschoolmanytomany.model.TeacherUpdateModel;

import java.util.Optional;

public class TeacherMapper {

    public static TeacherModel mapTeacherEntityToTeacherModel(Teacher teacher) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setId(teacher.getId());
        teacherModel.setFirstName(teacher.getFirstName());
        teacherModel.setMidName(teacher.getMidName());
        teacherModel.setLastName(teacher.getLastName());
        teacherModel.setEmail(teacher.getEmail());
        teacherModel.setPhone(teacher.getPhone());
        teacherModel.setDateOfBirth(teacher.getDateOfBirth());
        teacherModel.setCourses(teacher.getCourses());
        return teacherModel;
    }

    public static Teacher mapTeacherCreateModelToTeacherEntity (TeacherCreateModel teacherCreateModel) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherCreateModel.getFirstName());
        teacher.setMidName(teacherCreateModel.getMidName());
        teacher.setLastName(teacherCreateModel.getLastName());
        teacher.setEmail(teacherCreateModel.getEmail());
        teacher.setPhone(teacherCreateModel.getPhone());
        teacher.setDateOfBirth(teacherCreateModel.getDateOfBirth());
        return teacher;
    }

    public static void mapTeacherUpdateModelToTeacherEntity(Teacher teacher, TeacherUpdateModel teacherUpdateModel) {
        Optional.ofNullable(teacherUpdateModel.getFirstName()).ifPresent(teacher::setFirstName);
        Optional.ofNullable(teacherUpdateModel.getMidName()).ifPresent(teacher::setMidName);
        Optional.ofNullable(teacherUpdateModel.getLastName()).ifPresent(teacher::setLastName);
        Optional.ofNullable(teacherUpdateModel.getEmail()).ifPresent(teacher::setEmail);
        Optional.ofNullable(teacherUpdateModel.getPhone()).ifPresent(teacher::setPhone);
        Optional.ofNullable(teacherUpdateModel.getCourses()).ifPresent(teacher::setCourses);
    }

    public TeacherMapper() {
    }
}
