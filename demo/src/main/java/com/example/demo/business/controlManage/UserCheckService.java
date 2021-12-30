package com.example.demo.business.controlManage;

import java.time.LocalDate;

public interface UserCheckService {

	boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, LocalDate dateOfBirth);

}
