package com.crudusinghibernate.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crudusinghibernate.dao.UserDAO;
import com.crudusinghibernate.dao.UserDAOImpl;
import com.crudusinghibernate.dto.UserDto;
import com.crudusinghibernate.model.User;
import com.crudusinghibernate.util.TokenGeneration;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDAOImpl userdaoimpl;

//	@Value(value = "${url}")
//	private String url;

//	@Value(value = "${emailSource}")
//	private String emailSource;

//	@Autowired
//	private BCrypt bcryptEncoder;
	@Autowired
	private ModelMapper modelmapper;
	// @Autowired
	// private JavaMailSender emailSender;

	private static JavaMailSender emailSender = new JavaMailSenderImpl();

	private static PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private TokenGeneration token;

	@Transactional
	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	public User userDtoToEntity(UserDto userDto) {
		User user = new User();

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setIsVarify("false");
		LocalDateTime date=LocalDateTime.now();
		user.setCreatedTime(date);

		return user;
	}

	public UserDto entityTouserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());

		return userDto;
	}

	/*
	 * userdetails.setPassword(bCryptPasswordEncoder.encode(userdetails.getPassword(
	 * )));
	 * 
	 * 
	 */
	private String hashPassword(String plainTextPassword) {
		// String salt = bcryptEncoder.gensalt();
		// return bcryptEncoder.hashpw(plainTextPassword, salt);
		

		return bCryptPasswordEncoder.encode(plainTextPassword);

	}

	@Override
	public boolean verifyUser(String fromGeneratedToken) {
		String emailId = token.parseToken(fromGeneratedToken);
		if (userdaoimpl.isValidUser(emailId)) {
			userdaoimpl.changeStatus(emailId);
			return true;
		}
		return false;
	}

	@Override
	public void sendEmail(String url, String generatedToken) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo("vivekray037@gmail.com");
		// helper.setTo(emailSource);
		helper.setSubject("hello");
		helper.setText(url + generatedToken);
		emailSender.send(message);
	}

	@Transactional
	@Override
	public User getUserById(int studentId) {
		return userDAO.getUserById(studentId);

	}

	@Transactional
	@Override
	public int saveUser(UserDto userDto) throws MessagingException {
		String password = userDto.getPassword();
		String generatedToken = token.generateToken(userDto.getEmail());
		String url = "http://localhost:8080/verify/";
		userDto.setPassword(hashPassword(password));

		if (userDAO.saveUser(userDtoToEntity(userDto)) > 0) {
			sendEmail(url, generatedToken);
			return 1;
		} else {

			return 0;
		}

	}

	@Transactional
	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);

	}

}
