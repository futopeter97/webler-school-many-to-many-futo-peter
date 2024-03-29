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
public class CourseUpdateModel {

    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
