package com.bridgelabz.fundoo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;

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

import com.bridgelabz.fundoo.dto.ResetPasswords;
import com.bridgelabz.fundoo.dto.UserDto;
import com.bridgelabz.fundoo.exception.ErrorResponse;
import com.bridgelabz.fundoo.exception.UserNotFoundException;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	List<UserDto> getAllUser() {
		return userService.getAllUser();
	}

	@PostMapping(value = "/register")
	public ResponseEntity<Response> saveUser(@RequestBody UserDto user) throws MessagingException {
		String status = userService.validation(user);
		if (status.equalsIgnoreCase("Ok")) {
			if (userService.saveUser(user) > 0) {
				LocalDateTime date = LocalDateTime.now();
				user.setCreatedTime(date);
				user.setPassword("*********");
				return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Registerd Successfully!", user),
						HttpStatus.OK);
			} else
				return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(), "Registerd Failed!", user),
						HttpStatus.BAD_REQUEST);
		}

		else {
			return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(), status, user),
					HttpStatus.BAD_REQUEST);
		}

	}

// consuems='applicatin/json'
//consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
	@GetMapping(path = "/getuser/{userId}")
	public ResponseEntity<Response> getUserById(@PathVariable Long userId) {
		UserDto user = userService.getUserById(userId);
		if (user == null) {
			//return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(), "User is not Present!", user),
			//		HttpStatus.BAD_REQUEST);
			throw new UserNotFoundException();
			
		}
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(), "Found Successfully!", user), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public String deleteStudentById(@PathVariable Long userId) {
		// userService.deleteUser(userId);
		// if (!(userService.equals(null)))
		if (userService.deleteUser(userId) > 0)
			return "User deleted with id:" + userId;
		else
			return "User is not presents";

	}

	@GetMapping("/verify/{token}")
	public ResponseEntity<ErrorResponse> verifyUserByMail(@PathVariable("token") String token) {
		System.out.println("hello in verify");
		if (userService.isVarify(token) > 0) {
			if (userService.verifyUser(token)) {
				return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK.value(), " Varified Successfully!"),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Not verified"),
						HttpStatus.BAD_REQUEST);
			}
		} else
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Email is Already Varified, You can Login!"),
					HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<ErrorResponse> loginUser(@RequestBody UserDto user) {
		if (userService.loginUser(user)) {
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK.value(), "Login Successfully!"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Email/Passowrd is not valid"),
					HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/forget/{email}")
	public ResponseEntity<ErrorResponse> forgetPassword(@PathVariable("email") String email) throws MessagingException {
		if (userService.isUserPresent(email)) {
			userService.forgotPassword(email);
			return new ResponseEntity<>(
					new ErrorResponse(HttpStatus.OK.value(), "Link sent at Your Email " + email + " Successfully!"),
					HttpStatus.OK);
		} else
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "You Are Not Varified"),
					HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/reset/{token}")
	public ResponseEntity<ErrorResponse> updateUser(@PathVariable("token") String token,
			@RequestBody ResetPasswords resetPass) {
		if (userService.updateUser(token, resetPass) > 0) {
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK.value(), "Password Updated successfully"),
					HttpStatus.OK);
		} else
			return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Not Update"),
					HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/myPassword")
	public String MypassWords() {
		return null;

	}

}