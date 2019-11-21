package com.bridgelabz.fundoo.serviceImpl;

import java.util.List;

import javax.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundoo.dao.UserDAO;
import com.bridgelabz.fundoo.dao.UserDAOImpl;
import com.bridgelabz.fundoo.dto.ResetPasswords;
import com.bridgelabz.fundoo.dto.UserDto;
import com.bridgelabz.fundoo.model.User;
import com.bridgelabz.fundoo.service.*;
import com.bridgelabz.fundoo.util.MailServiceProvider;
import com.bridgelabz.fundoo.util.TokenGeneration;
import com.bridgelabz.fundoo.util.Utility;
import com.bridgelabz.fundoo.util.Validations;

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
	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private MailServiceProvider sender;

//	private static JavaMailSender emailSender = new JavaMailSenderImpl();
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	// private static PasswordEncoder bCryptPasswordEncoder = new
	// BCryptPasswordEncoder();

	@Autowired
	private TokenGeneration token;

	@Transactional
	@Override
	public List<UserDto> getAllUser() {
		return (Utility.userDtoConvertList(userDAO.getAllUser()));
	}

	private String hashPassword(String plainTextPassword) {
		return bCryptPasswordEncoder.encode(plainTextPassword);

	}

	@Transactional
	@Override
	public boolean verifyUser(String fromGeneratedToken) {

		try {
			String emailId = token.parseToken(fromGeneratedToken);
			if (userdaoimpl.isValidUser(emailId)) {
				userdaoimpl.changeStatus(emailId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("static-access")
	@Override
	public void sendEmail(String toEmail, String url, String generatedToken) throws MessagingException {

		sender.sendEmail(toEmail, "for Authorization", url + generatedToken);

	}

	@Transactional
	@Override
	public UserDto getUserById(Long userId) {
		return Utility.entityToUserDto(userDAO.getUserById(userId));

	}

	@Transactional
	@Override
	public int saveUser(UserDto userDto) throws MessagingException {
		String password = userDto.getPassword();
		String generatedToken = token.generateToken(userDto.getEmail());
		String url = "http://localhost:8080/users/verify/";
		userDto.setPassword(hashPassword(password));

		if (userDAO.saveUser(Utility.userDtoToEntity(userDto)) > 0) {
			sendEmail(userDto.getEmail(), url, generatedToken);
			return 1;
		} else {

			return 0;
		}

	}

	@Transactional
	@Override
	public int deleteUser(Long userId) {
		// suserDAO.deleteUser(userId);
		return userDAO.deleteUser(userId);

	}

	@Transactional
	@Override
	public boolean loginUser(UserDto loginUser) {
		String email = loginUser.getEmail();
		System.out.println("Login email==" + email);
		List<User> result = userdaoimpl.checkUser(loginUser.getEmail());
		return (bCryptPasswordEncoder.matches(loginUser.getPassword(), result.get(0).getPassword())) ? true : false;
	}

	@Override
	public boolean isUserPresent(String email) {
		return userdaoimpl.isValidUser(email);
	}

	@Override
	public boolean forgotPassword(String email) throws MessagingException {
		String generatedToken = token.generateToken(email);
		String url = "http://localhost:8080/users/reset/";
		sendEmail(email, url, generatedToken);
		return true;
	}

	@Transactional
	@Override
	public int updateUser(String generatedtoken, ResetPasswords passwordReset) {
		String emailId = token.parseToken(generatedtoken);
		String encodePassword = hashPassword(passwordReset.getNewPassword());
		passwordReset.setNewPassword(encodePassword);
		return userdaoimpl.updatePassword(emailId, passwordReset);
	}

	@Override
	public String validation(UserDto user) {

		return Validations.isValidFields(user);
	}
	@Transactional
	@Override
	public int isVarify(String generatedtoken) {
		return userdaoimpl.isVarify(token.parseToken(generatedtoken));
	}

}
