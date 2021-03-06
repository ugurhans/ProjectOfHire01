package com.example.demo.entities.concrates.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

	private String Email;
	private String password;
	private String companyName;
	private String webSite;
	private String phoneNumber;
}
