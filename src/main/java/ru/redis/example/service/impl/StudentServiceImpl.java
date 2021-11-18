package ru.redis.example.service.impl;

import java.util.List;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.redis.example.entity.Student;
import ru.redis.example.repository.StudentRepository;
import ru.redis.example.service.StudentService;

@Service
@CacheConfig(cacheNames = "studentCache")
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Cacheable(cacheNames = "students")
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @CacheEvict(cacheNames = "students", allEntries = true)
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(cacheNames = "student", key = "#id", unless = "#result == null")
    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
