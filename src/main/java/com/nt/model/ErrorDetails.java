package com.nt.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	//custom property names
	private LocalDateTime time;
	private String message;
	private String status;
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorDetails(LocalDateTime time, String message, String status) {
		super();
		this.time = time;
		this.message = message;
		this.status = status;
	}
	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

}
