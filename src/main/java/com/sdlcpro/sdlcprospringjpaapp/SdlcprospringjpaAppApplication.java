package com.sdlcpro.sdlcprospringjpaapp;

import com.sdlcpro.sdlcprospringjpaapp.dto.StudentDto;
import com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeAddressDto;
import com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeDTO;
import com.sdlcpro.sdlcprospringjpaapp.entities.Address;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student_;
import com.sdlcpro.sdlcprospringjpaapp.interfaceProjection.StudentNameAgeProjection;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepo;
import com.sdlcpro.sdlcprospringjpaapp.specification.StudentSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.support.WindowIterator;

import java.util.*;


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
//  var student =  studentRepo.findAll((Specification<Student>) (root, query, cb) -> cb.equal(root.get("id"),1));
//        Optional<Student> student =  studentRepo.findOne((root, query, cb) -> cb.equal(root.get("id"),1));
//        System.out.println(student.orElseThrow(()->new RuntimeException("product not found by this id")));

//  Specification<Student> specification = Specification.
//          where(StudentSpecification.byAddressName(Set.of("floor_one","floor_two"))
//                  .and(StudentSpecification.byAgeRange(10,50))
//                  .and(StudentSpecification.nameLike("abdullah"))
//          );

// Page<StudentNameAgeProjection> studentsPage = studentRepo.findBy(specification,
//
//         fetchableFluentQuery ->fetchableFluentQuery.as(StudentNameAgeProjection.class)
//                 .page(PageRequest.of(0,5)));
//
//
//
//       studentsPage.forEach(s-> System.out.println(s.getName()+" "+ s.getAge()+" "+"s******************"+s.getAddress()));
//
//       Specification<Student> specification1 = Specification.where(
//               StudentSpecification.byAgeRange(100,1000)
//       );
//      Page<Student> studentPage1 = studentRepo.findAll(specification1,PageRequest.of(0,5));
//      studentPage1.forEach(
//              System.out::println
//      );

        Address address = new Address();

        Student exampleStudent = new Student();

       exampleStudent.setName("a");


        var example = Example.of(exampleStudent,ExampleMatcher.matching().withMatcher(Student_.NAME, ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING)).withIgnoreCase()

        );

       var list =  studentRepo.findAll(example);
       list.forEach(System.out::println);



    }
}
