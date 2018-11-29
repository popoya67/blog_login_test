package com.example.test.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.app.config.LoginRequired;
import com.example.test.app.config.ResponseMessage;
import com.example.test.app.dto.User;

@RestController
public class BizController {
	@Autowired
	private HttpSession session;
	
	@GetMapping("user")
	@LoginRequired
	public ResponseEntity<ResponseMessage> getUser() {
		User user = (User)session.getAttribute("LOGIN_USER");
		return ResponseEntity.ok(new ResponseMessage(user));
	}
}
