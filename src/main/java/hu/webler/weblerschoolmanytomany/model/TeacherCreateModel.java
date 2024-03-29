package hu.webler.weblerschoolmanytomany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCreateModel {

    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDateTime dateOfBirth;

}
