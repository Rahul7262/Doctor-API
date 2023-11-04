package com.example.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.entity.ValidationResponse;
import com.example.exception.PatientNotFoundException;

@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		BindingResult br = ex.getBindingResult();
		List<ObjectError> listoe = br.getAllErrors();
		List<String> list = new ArrayList<>();

		for (ObjectError error : listoe) {
			list.add(error.getDefaultMessage());
		}
		ValidationResponse vr = new ValidationResponse("Validation failed...", list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vr);
	}

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatientNotFound(PatientNotFoundException ex) {

		List<String> list = new ArrayList<>();
		list.add(ex.getMessage());
		ValidationResponse vr = new ValidationResponse("Exception occurred...", list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vr);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleOtherExceptions(RuntimeException ex) {
		List<String> eList = new ArrayList<>();
		eList.add(ex.getMessage());
		ValidationResponse vr = new ValidationResponse("Exception occurred...", eList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vr);
	}

}
