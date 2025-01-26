package com.sdlcpro.sdlcprospringjpaapp.services;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    @Transactional

    public Student getStudentBynameId(Integer id, String name)
    {
//    var stream =  studentRepo.findAllByName("abdullah") ;
//    stream.skip(1000).limit(10)
//            .forEach(System.out::println);

        for(int i=0;i<100;i++)
        {
            var p = new Student();
            p.setName(UUID.randomUUID().toString());
            p.setAge((int) (Math.random()*1000));
            p.setAddress(new Address());
            studentRepo.save(p);
        }

        return studentRepo.getStudent(id,name);
    }




}
