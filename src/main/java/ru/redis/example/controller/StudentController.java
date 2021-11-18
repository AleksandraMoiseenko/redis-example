package ru.redis.example.controller;

import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.redis.example.service.StudentService;
import ru.redis.example.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping()
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

}
