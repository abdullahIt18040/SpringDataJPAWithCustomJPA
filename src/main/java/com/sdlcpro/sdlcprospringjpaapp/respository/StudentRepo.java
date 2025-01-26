package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>,StudentRepoCustom {
     @Query("select s from Student s where s.id=?1")
    Optional<Student>findById(Integer id);

     Student findByName(String name);
     Stream<Student> findAllByName(String name);
     List<Student>findStudentsByAddressName(String name);
     Streamable<Student>findStudentsByAddress_Name(String name);
     Streamable<Student>findStudentsByNameLike(Student name);
     @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT  )
     Stream<Student>findStudentsByIdBetween(int from,int to);

}
