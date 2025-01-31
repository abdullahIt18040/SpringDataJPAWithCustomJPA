package com.sdlcpro.sdlcprospringjpaapp;

import com.sdlcpro.sdlcprospringjpaapp.dto.StudentDto;
import com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeAddressDto;
import com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeDTO;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;
import org.springframework.data.support.WindowIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class SdlcprospringjpaAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SdlcprospringjpaAppApplication.class, args);


    }
@Autowired
private StudentRepo studentRepo;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

           var res =  studentRepo.findStudentById(1, StudentNameAgeDTO.class);
        System.out.println(res);

         var res2 = studentRepo.findStudentById(1, StudentDto.class);
        System.out.println(res2);
       List<StudentDto> res3 =  studentRepo.findStudentByAddress_Name("level",StudentDto.class,Limit.of(2));

        System.out.println(res3);

        var re4 = studentRepo.findStudentById(1);
        System.out.println("interface project"+re4.getAddress()+" name is "+re4.getName());
    }
}
