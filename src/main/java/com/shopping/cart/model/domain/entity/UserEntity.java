package com.shopping.cart.model.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = {"email"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
//    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ShoppingCartEntity> shoppingCartEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    //TODO equals hashcode
    public UserEntity() {
    }
    public UserEntity(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

    public Set<ShoppingCartEntity> getShoppingCartEntities() {
        return shoppingCartEntities;
    }
    public void setShoppingCartEntities(Set<ShoppingCartEntity> shoppingCartEntities) {
        this.shoppingCartEntities = shoppingCartEntities;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}