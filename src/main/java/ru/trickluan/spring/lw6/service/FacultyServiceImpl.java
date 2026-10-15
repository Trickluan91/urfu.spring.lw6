package ru.trickluan.spring.lw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trickluan.spring.lw6.dao.FacultyDAO;
import ru.trickluan.spring.lw6.entity.Faculty;
import ru.trickluan.spring.lw6.util.FacultyNotFound;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyDAO.getAllFaculties();
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyDAO.saveFaculty(faculty);
    }

    @Override
    public Faculty getFaculty(int id) {
        return facultyDAO.getFaculty(id).orElseThrow(() -> new FacultyNotFound(id));
    }

    @Override
    public void deleteFaculty(int id) {
        facultyDAO.deleteFaculty(id);
    }
}
