package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.UserConfirmationType;



public interface UserConfirmationTypeDao extends JpaRepository<UserConfirmationType, Integer> {

}
