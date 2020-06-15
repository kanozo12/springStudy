package net.kanozo.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			Object userVO = session.getAttribute("user");
			if (userVO != null) {
				return true;
			}
		}
		//로그인되지 않은 경우
		response.sendRedirect("/user/login");
		return false;
	}
}
