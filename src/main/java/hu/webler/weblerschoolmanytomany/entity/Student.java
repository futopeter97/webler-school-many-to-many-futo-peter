package hu.webler.weblerschoolmanytomany.entity;

import hu.webler.weblerschoolmanytomany.value.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    private LocalDateTime registrationDate = LocalDateTime.now();

    @Enumerated
    private Status status = Status.INACTIVE;

    private boolean isPaid = false;
}
