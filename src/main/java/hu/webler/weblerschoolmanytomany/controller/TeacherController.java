package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;
import hu.webler.weblerschoolmanytomany.model.TeacherUpdateModel;
import hu.webler.weblerschoolmanytomany.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherModel>> getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(teacherService.findTeacherById(id));
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherModel> createTeacher(@RequestBody TeacherCreateModel teacherCreateModel) {
        return ResponseEntity.status(200).body(teacherService.createTeacher(teacherCreateModel));
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/teacher/{id}")
    public ResponseEntity<TeacherModel> updateTeacher(@PathVariable Long id,
                                                      @RequestBody TeacherUpdateModel teacherUpdateModel) {
        return ResponseEntity.status(200).body(teacherService.updateTeacher(teacherUpdateModel, id));
    }
}
