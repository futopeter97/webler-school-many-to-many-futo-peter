package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.entity.base.Identifier;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Person extends Identifier {

    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDateTime dateOfBirth;
}
