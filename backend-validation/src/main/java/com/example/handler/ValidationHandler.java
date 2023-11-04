package com.example.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//RestController and ControllerAdvice  ka combination hai 
@RestControllerAdvice // for advice to validate data 
public class ValidationHandler extends ResponseEntityExceptionHandler {

	// this method is called when data is not valid accept from user jo ki @valid
	// annotation se check ho jaayega ise hi kahte hai backend validation
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		//get BindingResult interface ka object from ex ki getbindingResult method se 
	BindingResult br= ex.getBindingResult();
	
	
	// br se ObjectError objectError ke object ka list collection
   List<ObjectError> errorlist= br.getAllErrors();
   
   // khud ke lia ek alg se list collection bnaya hu 
   List <String> list = new ArrayList<>();
   
   
   for(ObjectError error : errorlist) {
	  
	   list.add(error.getDefaultMessage());
   }
   
   
		ValidationResponce validationResponce = new ValidationResponce("Validation Failed.......", list);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponce);
	}

}
