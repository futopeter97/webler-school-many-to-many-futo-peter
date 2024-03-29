package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.Teacher;
import hu.webler.weblerschoolmanytomany.model.TeacherCreateModel;
import hu.webler.weblerschoolmanytomany.model.TeacherModel;
import hu.webler.weblerschoolmanytomany.model.TeacherUpdateModel;
import hu.webler.weblerschoolmanytomany.persistence.TeacherRepository;
import hu.webler.weblerschoolmanytomany.util.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherModel> getTeacher() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::mapTeacherEntityToTeacherModel)
                .collect(Collectors.toList());
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id)
                .orElseThrow(() -> {
                    String message = String.format("Teacher with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public TeacherModel createTeacher(TeacherCreateModel teacherCreateModel) {
        return TeacherMapper.mapTeacherEntityToTeacherModel(teacherRepository
                .save(TeacherMapper.mapTeacherCreateModelToTeacherEntity(teacherCreateModel)));
    }

    public void deleteTeacher(Long id) {
        findTeacherById(id);
        teacherRepository.deleteById(id);
    }

    public TeacherModel updateTeacher(TeacherUpdateModel teacherUpdateModel, Long id) {
        Teacher teacher = findTeacherById(id);
        TeacherMapper.mapTeacherUpdateModelToTeacherEntity(teacher, teacherUpdateModel);
        teacher = teacherRepository.save(teacher);
        return TeacherMapper.mapTeacherEntityToTeacherModel(teacher);
    }
}
