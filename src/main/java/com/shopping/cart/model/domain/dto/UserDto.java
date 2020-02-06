package com.shopping.cart.model.domain.dto;

import com.shopping.cart.model.domain.entity.RoleEntity;
import com.shopping.cart.model.domain.entity.ShoppingCartEntity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements Serializable {
    private static final long serialVersionUID = -944912890747315243L;

    private Long id;
    private String name ;
    private String surname ;
    private String email ;
    private String password ;
    private Set<ShoppingCartEntity> items ;
    private Set<RoleEntity> roles ;

    public UserDto() { }
    public UserDto(Long id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    public UserDto(Long id, String name, String surname, String email, String password, Set<ShoppingCartEntity> items, Set<RoleEntity> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.items = items;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public Set<ShoppingCartEntity> getItems() {
        return items;
    }
    public void setItems(Set<ShoppingCartEntity> items) {
        this.items = items;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
