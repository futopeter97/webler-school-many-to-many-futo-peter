package hu.webler.weblerschoolmanytomany.util;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.SchoolUpdateModel;

import java.util.Optional;

public class SchoolMapper {

    public static SchoolModel mapSchoolEntityToSchoolModel(School school) {
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setId(school.getId());
        schoolModel.setName(school.getName());
        schoolModel.setAddress(school.getAddress());
        schoolModel.setCourses(school.getCourses());
        return schoolModel;
    }

    public static School mapSchoolCreateModelToSchoolEntity(SchoolCreateModel schoolCreateModel) {
        School school = new School();
        school.setName(schoolCreateModel.getName());
        school.setAddress(schoolCreateModel.getAddress());
        return school;
    }

    public static void mapSchoolUpdateModelToSchoolEntity(School school, SchoolUpdateModel schoolUpdateModel) {
        Optional.ofNullable(schoolUpdateModel.getName()).ifPresent(school::setName);
        Optional.ofNullable(schoolUpdateModel.getAddress()).ifPresent(school::setAddress);
        Optional.ofNullable(schoolUpdateModel.getCourses()).ifPresent(school::setCourses);
    }

    public SchoolMapper() {
    }
}
