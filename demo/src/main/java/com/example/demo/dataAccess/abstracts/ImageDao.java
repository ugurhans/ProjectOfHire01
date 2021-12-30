package com.example.demo.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concrates.concretes.Image;



public interface ImageDao extends JpaRepository<Image, Integer> {

	Image getByUser_Id(int userId);

}
