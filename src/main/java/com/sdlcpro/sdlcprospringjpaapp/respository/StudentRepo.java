package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.dto.StudentDto;
import com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeAddressDto;
import com.sdlcpro.sdlcprospringjpaapp.entities.Address;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.interfaceProjection.StudentNameAgeProjection;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>,StudentRepoCustom {

//@Query("select new com.sdlcpro.sdlcprospringjpaapp.dto.StudentDto(s.id,s.name,s.email,s.age,s.address) from Student s where s.id=?1")
//StudentDto findStudentById(Integer id);
//@Query("select new com.sdlcpro.sdlcprospringjpaapp.dto.StudentNameAgeDTO(s.name,s.age) from Student  s where s.id =?1")
//StudentNameAgeDTO findStudentNameAndAge(Integer id);

    <T> T findStudentById(Integer id,Class<T>clazz);
    <T> List<T> findStudentByAddress_Name(String name, Class<T>tClass,Limit limit);

    StudentNameAgeProjection findStudentById(Integer id);

}
