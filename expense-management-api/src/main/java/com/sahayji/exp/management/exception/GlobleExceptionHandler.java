package com.sahayji.exp.management.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundException(ResourceNotFoundException e){
		Map<String,Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserAllReadyExistException.class)
	public ResponseEntity<Map<String, Object>> userAllreadyExistException(UserAllReadyExistException e){
		Map<String,Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("status", HttpStatus.CONFLICT.value());
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.CONFLICT);
	}

}
