package com.example.duantn.repository;

import com.example.duantn.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
    Role findByName(String name);
}
