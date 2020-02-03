package com.shopping.cart.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
//@Table(name = "users", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "username"
//        }),
//        @UniqueConstraint(columnNames = {
//                "email"
//        })
//})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @NotBlank
//    @Size(min=3, max = 50)
    private String name;
    private String surname;
    @Column(unique = true)
//    @NaturalId
//    @NotBlank
//    @Size(max = 50)
//    @Emai
    private String email;
    private String password;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ShoppingCartEntity> shoppingCartEntities;

//TODO equals hashcode
    public UserEntity() {
    }

    public UserEntity(String name, String surname, String email, String password) {
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