package com.sdlcpro.sdlcprospringjpaapp.services;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.AddressRepo;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private AddressRepo addressRepo;
    public String saveAddress( Address address)
    {

      Address address1 = addressRepo.save(address);

        if(address1 !=null)
        {
            return "address Save Successfully ";
        }
        return "not save";

    }

    public String saveStudent( Student student)
    {

       Student student1 =  studentRepo.save(student);
       if(student1 !=null)
       {
           return "Student Save Successfully ";
       }
       return "not save";

    }







}
