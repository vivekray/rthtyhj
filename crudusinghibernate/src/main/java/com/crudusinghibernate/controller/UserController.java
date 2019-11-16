package com.crudusinghibernate.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudusinghibernate.dto.UserDto;
import com.crudusinghibernate.exception.ErrorResponse;
import com.crudusinghibernate.model.User;
import com.crudusinghibernate.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/userlist")
	List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PostMapping("/register")
	public ResponseEntity<ErrorResponse> saveUser(@RequestBody UserDto user) throws MessagingException {
     if (userService.saveUser(user) > 0)
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK.value(), "success"), HttpStatus.OK);
		else
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "not verified"),
					HttpStatus.BAD_REQUEST);

	}

	@GetMapping(path = "/getuser/{userId}",consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public User getUserById(@PathVariable int userId) {
		User student = userService.getUserById(userId);
		if (student == null) {
			throw new RuntimeException("User with id:" + userId + "not found");
		}
		return student;
	}

	@RequestMapping("/deleteuser/{userId}")
	public String deleteStudentById(@PathVariable int studentId) {
		userService.deleteUser(studentId);
		if (!(userService.equals(null)))
			return "Student deleted with id:" + studentId;
		else
			return "StudentId is not presents";

	}
	
	
	@GetMapping("/verify/{token}")
	public ResponseEntity<ErrorResponse> verifyUserByMail(@PathVariable("token") String token) {
		System.out.println("hello in verify");
		if (userService.verifyUser(token)) {
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK.value(), "success"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "not verified"),
					HttpStatus.BAD_REQUEST);

		}
	}

}
