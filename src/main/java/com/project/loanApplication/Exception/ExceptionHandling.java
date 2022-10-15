package com.project.loanApplication.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling 
{
	@ExceptionHandler(Exception.class)
	public Map<String, String> exceptionHanding(Exception exception)
	{
		Map<String, String> errors = new HashMap<>();
		errors.put(exception.getLocalizedMessage(),exception.getClass().toString());
		return errors;
	}
}
