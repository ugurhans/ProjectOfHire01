package com.example.demo.business.abstracts;

import com.example.demo.core.entities.User;
import com.example.demo.core.results.Result;


public interface EmailService {

	Result sendEmail(User user);

}
