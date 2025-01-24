package com.sdlcpro.sdlcprospringjpaapp.services;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public String saveStudent( Student student)
    {

       Student student1 =  studentRepo.save(student);
       if(student1 !=null)
       {
           return "Student Save Successfully ";
       }
       return "not save";

    }
    public Student getStudentBynameId(Integer id, String name)
    {
        return studentRepo.getStudent(id,name);
    }


}
