package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.SchoolUpdateModel;
import hu.webler.weblerschoolmanytomany.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/schools")
    public ResponseEntity<List<SchoolModel>> getAllSchools() {
        return ResponseEntity.status(200).body(schoolService.getSchool());
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<School> findSchoolById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(schoolService.findSchoolById(id));
    }

    @PostMapping("/schools")
    public ResponseEntity<SchoolModel> createSchool(@RequestBody SchoolCreateModel schoolCreateModel) {
        return ResponseEntity.status(200).body(schoolService.createSchool(schoolCreateModel));
    }

    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/schools/{id}")
    public ResponseEntity<SchoolModel> updateSchool(@PathVariable Long id,
                                                    @RequestBody SchoolUpdateModel schoolUpdateModel) {
        return ResponseEntity.status(200).body(schoolService.updateSchool(schoolUpdateModel, id));
    }
}
