package com.shopping.cart.repository;

import com.shopping.cart.domain.entity.RoleEntity;
import com.shopping.cart.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleName roleName);
}
