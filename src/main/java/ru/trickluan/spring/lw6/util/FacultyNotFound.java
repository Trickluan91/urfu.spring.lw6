package ru.trickluan.spring.lw6.util;

public class FacultyNotFound extends RuntimeException {
    public FacultyNotFound(int id) {
        super("Faculty not found with id " + id);
    }
}
