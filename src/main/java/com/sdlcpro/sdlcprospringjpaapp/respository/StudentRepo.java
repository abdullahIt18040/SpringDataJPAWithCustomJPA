package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

Page<Student>findStudentsByAddressName(String name,Pageable pageable);
}
