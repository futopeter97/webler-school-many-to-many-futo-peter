package hu.webler.weblerschoolmanytomany.model;

import hu.webler.weblerschoolmanytomany.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private String phone;
    private String email;
    private LocalDateTime dateOfBirth;
    private List<Course> courses;
}
