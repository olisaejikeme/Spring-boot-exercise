package com.example.demo.web;

import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add-student")
    public String addStudent(Student student) {
        return "CreateStudent";
    }

    @PostMapping("/add-student")
    public String addStudentPost(Student student) {
        System.out.println(student.toString());
        studentService.addStudent(student);
        return "redirect:/page/list-students";
    }

    @GetMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, Model model) throws Exception {
        Student existing = studentService.getStudentById(id);
        model.addAttribute("student", existing);
        return "update-student";
    }

    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable Long id, Student student) throws Exception {
        System.out.println(student.toString());
        studentService.updateStudent(id, student);
        return "redirect:/page/list-students";
    }

    @GetMapping("/list-students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id, Student student) {
        studentService.deleteStudent(id);
        return "redirect:/page/list-students";
    }
}
