package ru.redis.example.service;

import java.util.List;
import ru.redis.example.entity.Student;

public interface StudentService {

    List<Student> getAll();

    Student save(Student student);

    Student findById(Long id);

}
