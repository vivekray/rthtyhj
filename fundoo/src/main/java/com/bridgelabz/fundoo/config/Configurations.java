package com.bridgelabz.fundoo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bridgelabz.fundoo.util.TokenGeneration;

@Configuration
public class Configurations {
	@Bean
	public ModelMapper setModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

   @Bean
	public PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
	}
	

	@Bean
	public TokenGeneration token() {
		return new TokenGeneration();
	}
	
	
//	@Bean
//	public JavaMailSender getMailsender() {
//		return new JavaMailSenderImpl() ;
//			
			
	//}
//	@Bean
//	public MailServiceProvider getMailServiceProvider() {
//		return new MailServiceProvider();
//	}

}