package com.shopping.cart.repository;

import com.shopping.cart.domain.entity.RoleEntity;
import com.shopping.cart.security.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link RoleEntity}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleName roleName);
}
