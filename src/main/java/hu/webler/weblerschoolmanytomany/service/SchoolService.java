package hu.webler.weblerschoolmanytomany.service;

import hu.webler.weblerschoolmanytomany.entity.School;
import hu.webler.weblerschoolmanytomany.model.SchoolModel;
import hu.webler.weblerschoolmanytomany.model.SchoolCreateModel;
import hu.webler.weblerschoolmanytomany.model.SchoolUpdateModel;
import hu.webler.weblerschoolmanytomany.util.SchoolMapper;
import hu.webler.weblerschoolmanytomany.persistence.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<SchoolModel> getSchool() {
        return schoolRepository.findAll()
                .stream()
                .map(SchoolMapper::mapSchoolEntityToSchoolModel)
                .collect(Collectors.toList());
    }

    public School findSchoolById(Long id) {
        return schoolRepository.findSchoolById(id)
                .orElseThrow(() -> {
                    String message = String.format("School with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public SchoolModel createSchool(SchoolCreateModel schoolCreateModel) {
        return SchoolMapper.mapSchoolEntityToSchoolModel(schoolRepository
                .save(SchoolMapper.mapSchoolCreateModelToSchoolEntity(schoolCreateModel)));
    }

    public void deleteSchool(Long id) {
    }
}
