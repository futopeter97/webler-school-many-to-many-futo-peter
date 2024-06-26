package hu.webler.weblerschoolmanytomany.model;

import hu.webler.weblerschoolmanytomany.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private List<Course> courses;
}
