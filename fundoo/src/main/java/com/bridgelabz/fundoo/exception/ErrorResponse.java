package com.bridgelabz.fundoo.exception;

import java.io.Serializable;

import com.bridgelabz.fundoo.response.Response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class ErrorResponse implements Serializable{

	private Integer status;
	
	private String message;
	
	//private Object data;

	public ErrorResponse(int status, String message) {
	//	super(status,message,data);
		this.status = status;
		this.message = message;
		
	}
	
}
