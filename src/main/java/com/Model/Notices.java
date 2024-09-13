package com.Model;

import java.util.ArrayList;
import java.util.List;

public class Notices implements ModelInterface {
	private String idNotices;
	private String title;
	private String message;
	private String targetRole;
	private String date;
	 @Override
	    public List<String> toRow(List<String> fields) {
		 List<String> row = new ArrayList<>();
		 if(fields.contains("title")) {
			row.add(title);
		}
		 if(fields.contains("message")) {
			row.add(message);
		}
		 if(fields.contains("date")) {
			row.add(date);
		}
		 if(fields.contains("targetRole")) {
			row.add(targetRole);
		}
		 return row;
	    }
	// Getters and Setters
	public String getIdNotices() {
		return idNotices;
	}

	public void setIdNotices(String string) {
		this.idNotices = string;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public String getTargetRole() {
		return targetRole;
	}

	public void setTargetRole(String targetRole) {
		this.targetRole = targetRole;
	}
}
