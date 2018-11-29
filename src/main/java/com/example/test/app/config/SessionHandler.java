package com.example.test.app.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class SessionHandler extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			if(hm.hasMethodAnnotation(LoginRequired.class)&& request.getSession().getAttribute("LOGIN_USER") == null) {
				throw new IllegalAccessException("로그인되어있지 않습니다.");
			}
		}
		return super.preHandle(request, response, handler);
	}

}
