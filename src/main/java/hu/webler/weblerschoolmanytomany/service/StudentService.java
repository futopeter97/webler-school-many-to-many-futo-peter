package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Student;
import hu.webler.weblerschoolmanytomany.model.StudentCreateModel;
import hu.webler.weblerschoolmanytomany.model.StudentModel;
import hu.webler.weblerschoolmanytomany.model.StudentUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.StudentRepository;
import hu.webler.weblerschoolmanytomany.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentModel> getStudent() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapStudentEntityToStudentModel)
                .collect(Collectors.toList());
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> {
                    String message = String.format("Student with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public StudentModel createStudent(StudentCreateModel studentCreateModel) {
        return StudentMapper.mapStudentEntityToStudentModel(studentRepository
                .save(StudentMapper.mapStudentCreateModelToStudentEntity(studentCreateModel)));
    }

    public void deleteStudent(Long id) {
        findStudentById(id);
        studentRepository.deleteById(id);
    }

    public StudentModel updateStudent(StudentUpdateModel studentUpdateModel, Long id) {
        Student student = findStudentById(id);
        StudentMapper.mapStudentUpdateModelToStudentEntity(student, studentUpdateModel);
        student = studentRepository.save(student);
        return StudentMapper.mapStudentEntityToStudentModel(student);
    }
}
