package com.bridgelabz.fundoo.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class Response implements Serializable {

	private Integer status;
	
	private String message;
	
	private Object data;

	public Response(Integer status, String message,Object data) {
		this.status = status;
		this.message = message;
		this.data=data;
		
	}
}
