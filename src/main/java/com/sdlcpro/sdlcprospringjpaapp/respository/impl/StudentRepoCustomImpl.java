package com.sdlcpro.sdlcprospringjpaapp.respository.impl;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;
import com.sdlcpro.sdlcprospringjpaapp.respository.StudentRepoCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepoCustomImpl implements StudentRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;
//    @Override
//    public Student getStudent(Integer id, String name) {
//        StringBuilder sql = new StringBuilder("SELECT s FROM Student s WHERE 1=1");
//
//        if (id != null) {
//            sql.append(" AND s.id = :id");
//        }
//        if (name != null) {
//            sql.append(" AND s.name = :name");
//        }
//
//        TypedQuery<Student> query = entityManager.createQuery(sql.toString(), Student.class);
//
//        if (id != null) {
//            query.setParameter("id", id);
//        }
//        if (name != null) {
//            query.setParameter("name", name);
//        }
//
//        try {
//            // Return the result if found
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            // Handle the case when no result is found
//            return null; // Or handle this differently, like throwing a custom exception
//        }
//    }

    @Override
    public Student getStudent(Integer id, String name) {
        StringBuilder sql = new StringBuilder("select s from Student s where ");

        if(id !=null && name != null)
        {
            sql.append(" id=").append(id).append(" and name='").append(name).append("'");

        }else if(name==null)
        {
            sql.append(" id="+id);
        }else {
            sql.append(" name='"+name+"'");
        }

      return   entityManager.createQuery(sql.toString(), Student.class).getSingleResult();

    }
}
