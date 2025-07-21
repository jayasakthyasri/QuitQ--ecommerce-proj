package com.springboot.Quitq_ecommerce_proj.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Quitq_ecommerce_proj.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
