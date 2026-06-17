package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.example.studentmanagement.dto.StudentRequestDTO;
import com.example.studentmanagement.dto.StudentResponseDTO;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public Page<Student> getStudentsPaginated(int page, int size) {
    return repo.findAll(PageRequest.of(page, size));
    }
    
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public List<Student> searchByName(String name) {
    return repo.findByName(name);
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getStudentsSorted(String field) {
    return repo.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {

    Student student = new Student();

    student.setName(dto.getName());
    student.setEmail(dto.getEmail());
    student.setPhone(dto.getPhone());

    Student savedStudent = repo.save(student);

    StudentResponseDTO response = new StudentResponseDTO();

    response.setId(savedStudent.getId());
    response.setName(savedStudent.getName());
    response.setEmail(savedStudent.getEmail());
    response.setPhone(savedStudent.getPhone());

    return response;
}
    
}

