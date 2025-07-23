package com.springboot.Quitq_ecommerce_proj.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {
	
	Optional<Admin> findByEmail(String email);

}
