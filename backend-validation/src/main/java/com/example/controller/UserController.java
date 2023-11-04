package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;

@Controller
@ResponseBody
@RequestMapping("user")
public class UserController {
	
	
	@PostMapping("create")
	public ResponseEntity<User>  createUser(@Valid @RequestBody User user){
		
		System.out.println("Post API Called........");
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

}
