package com.maxi.stockmanagment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.stockmanagment.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
