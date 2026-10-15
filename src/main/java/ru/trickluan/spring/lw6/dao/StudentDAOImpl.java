package ru.trickluan.spring.lw6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.trickluan.spring.lw6.entity.Student;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createQuery("from Student");
        List<Student> students = query.getResultList();
        log.info("getAllStudents():{}", students);
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Optional<Student> getStudent(int id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public void deleteStudent(int id) {
        Query query = entityManager.createQuery("delete from student where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
