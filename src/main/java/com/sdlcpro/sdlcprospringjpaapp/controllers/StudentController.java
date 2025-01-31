package com.sdlcpro.sdlcprospringjpaapp.controllers;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
@Autowired
    private StudentService studentService;
    @PostMapping("/savestudent")
    public String saveStudent(@RequestBody Student student)
    {
      return   studentService.saveStudent(student);

    }


    @PostMapping("/saveaddress")
    public String saveAddress(@RequestBody Address address)
    {
        return studentService.saveAddress(address);
    }
    @GetMapping("/getstudent")
    public Student getStudent(@RequestParam(value = "id", required = false) Integer id,
                              @RequestParam(value = "name", required = false) String name) {
        return studentService.getStudentBynameId(id,name);
    }


}
