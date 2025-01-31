package com.sdlcpro.sdlcprospringjpaapp.interfaceProjection;

public interface StudentNameAgeProjection {


    String getName();
    Integer getAge();
    AddressNameProjection getAddress();

    interface AddressNameProjection{
        String getName();
    }



}
