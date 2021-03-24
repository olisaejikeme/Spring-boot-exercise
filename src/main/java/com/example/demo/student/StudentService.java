package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student updateStudent(Long id, Student update) throws Exception {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            Student existing = optional.get();
            existing.setName(update.getName());
            //...
            return studentRepository.save(existing);
        } else {
            throw new Exception("Student with id: " + id + " not found");
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) throws Exception {
       Optional<Student> result = studentRepository.findById(studentId);
       if(result.isEmpty()) {
           throw new Exception("Student with id: " + studentId + " not found");
       }
       return result.get();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
