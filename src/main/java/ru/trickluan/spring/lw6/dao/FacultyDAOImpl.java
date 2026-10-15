package ru.trickluan.spring.lw6.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.trickluan.spring.lw6.entity.Faculty;
import ru.trickluan.spring.lw6.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class FacultyDAOImpl implements FacultyDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Faculty> getAllFaculties() {
        return entityManager.createQuery("from Faculty", Faculty.class).getResultList();
    }

    @Override
    @Transactional
    public Faculty saveFaculty(Faculty faculty) {
        return entityManager.merge(faculty);
    }

    @Override
    @Transactional
    public Optional<Faculty> getFaculty(int id) {
        return Optional.ofNullable(entityManager.find(Faculty.class, id));
    }

    @Override
    public void deleteFaculty(int id) {
        Query query = entityManager.createQuery("delete from Faculty where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
