package com.sdlcpro.sdlcprospringjpaapp.respository;

import com.sdlcpro.sdlcprospringjpaapp.entities.Student;

public interface StudentRepoCustom {
    Student getStudent(Integer id, String name);
}
