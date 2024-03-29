package hu.webler.weblerschoolmanytomany.model;

import hu.webler.weblerschoolmanytomany.entity.Course;
import hu.webler.weblerschoolmanytomany.value.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateModel {

    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String email;
    private Status status;
    private List<Course> courses;
}
