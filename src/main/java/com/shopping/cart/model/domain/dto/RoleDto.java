package com.shopping.cart.model.domain.dto;

import com.shopping.cart.model.domain.enums.RoleName;
import java.io.Serializable;

public class RoleDto implements Serializable {
    private static final long serialVersionUID = 4751561840382499028L;

    private Long id;
    private RoleName name;

    public RoleDto() { }
    public RoleDto(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }

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
