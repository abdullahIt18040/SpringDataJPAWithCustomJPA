package com.sdlcpro.sdlcprospringjpaapp.specification;

import com.sdlcpro.sdlcprospringjpaapp.entities.Address_;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.entities.Student_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public interface StudentSpecification {

    static Specification<Student> byAddressName(Set<String>addressNmaes)
    {
        if (addressNmaes==null || addressNmaes.isEmpty()) return null;

        return((root, query, cb) ->root.get(Student_.ADDRESS).get(Address_.NAME).in(addressNmaes) );
    }

    static Specification<Student> byAgeRange(Integer start,Integer end)
    {
        if(start == null || end==null || end<start) return  null;
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.greaterThanOrEqualTo(root.get(Student_.AGE),start),
                criteriaBuilder.lessThanOrEqualTo(root.get(Student_.AGE),end)

        ));
    }

    static Specification<Student> nameLike(String  name){
        if(name == null || name.isBlank()) return null;
        return ((root, query, cb) -> cb.like(root.get(Student_.NAME),"%"+name+"%"));
    }



}
