package com.shopping.cart.domain.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class UserDto implements Serializable {
    private static final long serialVersionUID = -944912890747315243L;

    public enum Role{
        ROLE_ADMIN, ROLE_USER
    }

    private Integer id;
    private String name ;
    private String surname ;
    private String email ;
    private String password ;

    public UserDto() { }
    public UserDto(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
