package ru.trickluan.spring.lw6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.trickluan.spring.lw6.entity.Faculty;
import ru.trickluan.spring.lw6.service.FacultyService;
import ru.trickluan.spring.lw6.util.FacultyNotFound;

import java.util.List;

@Controller
@RequestMapping("/api")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> allfaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/faculty/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable int id) {
        Faculty faculty;
        try {
            faculty = facultyService.getFaculty(id);
        } catch (FacultyNotFound e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping("faculty")
    public ResponseEntity<Faculty> saveFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFaculty);
    }

    @PutMapping("/faculty")
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable int id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
}
