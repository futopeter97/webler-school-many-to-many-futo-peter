package hu.webler.weblerschoolmanytomany.controller;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.StudentUpdateModel;
import hu.webler.weblerschoolmanytomany.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getStudent());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(studentService.findStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentCreateModel studentCreateModel) {
        return ResponseEntity.status(200).body(studentService.createStudent(studentCreateModel));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id,
                                                      @RequestBody StudentUpdateModel studentUpdateModel) {
        return ResponseEntity.status(200).body(studentService.updateStudent(studentUpdateModel, id));
    }
}
