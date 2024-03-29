package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
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

    @PostMapping("/schools")
    public ResponseEntity<SchoolModel> createSchool(@RequestBody SchoolCreateModel schoolCreateModel) {
        return ResponseEntity.status(200).body(schoolService.createSchool(schoolCreateModel));
    }
}
