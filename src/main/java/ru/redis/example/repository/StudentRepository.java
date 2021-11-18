package ru.redis.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.redis.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
