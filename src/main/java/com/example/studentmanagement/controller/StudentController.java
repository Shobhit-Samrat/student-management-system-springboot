package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import com.example.studentmanagement.dto.StudentRequestDTO;
import com.example.studentmanagement.dto.StudentResponseDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // POST
    @PostMapping
    public StudentResponseDTO addStudent(
        @Valid @RequestBody StudentRequestDTO dto) {

    return service.saveStudent(dto);
    }
    
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
    return service.updateStudent(student);
    }
    
    // GET
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
    return service.getStudentById(id);
    }

    @GetMapping("/search/{name}")
    public List<Student> searchByName(@PathVariable String name) {
    return service.searchByName(name);
    }
    
    @GetMapping("/page")
    public Page<Student> getStudentsPaginated(
        @RequestParam int page,
        @RequestParam int size) {

    return service.getStudentsPaginated(page, size);
    }
    
    @GetMapping("/sort/{field}")
    public List<Student> getStudentsSorted(@PathVariable String field) {
    return service.getStudentsSorted(field);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }
}
