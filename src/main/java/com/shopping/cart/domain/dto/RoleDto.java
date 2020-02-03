package com.shopping.cart.domain.dto;

import com.shopping.cart.security.RoleName;
import java.io.Serializable;

public class RoleDto implements Serializable {
    private static final long serialVersionUID = 4751561840382499028L;

    private Long id;
    private RoleName name;

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
}
