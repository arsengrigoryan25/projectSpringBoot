package com.shopping.cart.domain.entity;

import com.shopping.cart.security.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

/**
 * Simple domain object that represents application user's role - ADMIN, USER, etc.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }
    public void setName(RoleName name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }
    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
