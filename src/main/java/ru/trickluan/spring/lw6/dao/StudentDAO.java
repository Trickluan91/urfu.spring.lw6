package ru.trickluan.spring.lw6.dao;

import org.springframework.stereotype.Repository;
import ru.trickluan.spring.lw6.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Optional<Student> getStudent(int id);
    void deleteStudent(int id);
}
