package ru.trickluan.spring.lw6.service;

import org.springframework.stereotype.Service;
import ru.trickluan.spring.lw6.entity.Faculty;
import ru.trickluan.spring.lw6.entity.Student;

import java.util.List;

@Service
public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty saveFaculty(Faculty faculty);
    Faculty getFaculty(int id);
    void deleteFaculty(int id);
}
