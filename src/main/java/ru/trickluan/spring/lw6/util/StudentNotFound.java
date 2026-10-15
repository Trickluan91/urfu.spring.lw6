package ru.trickluan.spring.lw6.util;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(int id) {
        super("Student not found with id = " + id);
    }
}
