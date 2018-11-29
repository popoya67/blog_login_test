package com.example.test.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.app.config.ResponseMessage;
import com.example.test.app.dto.User;

@RestController
public class LoginController {
	@Autowired
	private HttpSession session;
	
	@PostMapping("login")
	public ResponseEntity<ResponseMessage> login(@RequestBody User user) {
		// TODO 일치하는지 확인하는 logic 추가
		session.setAttribute("LOGIN_USER", user);
		//쿠키를 직접넣어주지 않아도, 발급했으므로 response 쿠키에 추가됨. (JSESSIONID라는 이름으로!)
		
		return ResponseEntity.ok(new ResponseMessage(true));
	}
}
