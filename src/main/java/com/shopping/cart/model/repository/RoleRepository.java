package com.shopping.cart.model.repository;

import com.shopping.cart.model.domain.entity.RoleEntity;
import com.shopping.cart.model.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleName roleName);
}
