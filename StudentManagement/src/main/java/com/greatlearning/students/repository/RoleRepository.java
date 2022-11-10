package com.greatlearning.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.students.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
}
