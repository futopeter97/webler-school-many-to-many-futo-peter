package hu.webler.weblerschoolmanytomany.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courseList;
}
