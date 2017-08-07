package com.task.model;

public class Task {
	
	private long id;
	private String subject;
	private String detail;
	private String status;
	
	public Task(){
		id=0;
	}
	
	public Task(long id, String subject, String detail, String status) {
		this.id = id;
		this.subject = subject;
		this.detail = detail;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Task [id="+id+", subject=" + subject + ", detail=" + detail + ", staus=" + status+ "]";
	}

}
