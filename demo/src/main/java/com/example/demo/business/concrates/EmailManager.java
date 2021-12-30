package com.example.demo.business.concrates;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmailService;
import com.example.demo.core.entities.User;
import com.example.demo.core.results.Result;
import com.example.demo.core.results.SuccessResult;


@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult(user.getEmail() + " adresine e-posta gönderildi.");
	}

}
