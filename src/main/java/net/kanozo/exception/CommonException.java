package net.kanozo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("net.kanozo.controller")
public class CommonException {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "globalException";
	}
}
