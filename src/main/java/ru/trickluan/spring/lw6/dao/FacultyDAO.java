package ru.trickluan.spring.lw6.dao;

import org.springframework.stereotype.Repository;
import ru.trickluan.spring.lw6.entity.Faculty;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyDAO {
    List<Faculty> getAllFaculties();
    Faculty saveFaculty(Faculty faculty);
    Optional<Faculty> getFaculty(int id);
    void deleteFaculty(int id);
}
