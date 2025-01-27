package com.sdlcpro.sdlcprospringjpaapp;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@SpringBootApplication
public class SdlcprospringjpaAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SdlcprospringjpaAppApplication.class, args);


    }
    @Autowired
private StudentRepo studentRepo;
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Sort sort = Sort.by(Sort.Order.by("id"));
        Sort.TypedSort<Student> studentTypedSort = Sort.sort(Student.class);
          Sort sort1 = studentTypedSort.by(Student::getId).ascending();

        Pageable pageable = PageRequest.of(2,10, sort);
      Page<Student> studentPage =  studentRepo.findStudentsByAddressName("abdullah",pageable);
      studentPage.getContent();
        System.out.println(studentPage);





    }
}
