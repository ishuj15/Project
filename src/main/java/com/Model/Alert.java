package com.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Alert implements ModelInterface {
	private String idAlert;
	private String message;
	private Date date;
	private String targetRole;

	// Getters and Setters
	public String getIdAlert() {
		return idAlert;
	}

	public void setIdAlert(String idAlert) {
		this.idAlert = idAlert;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTargetRole() {
		return targetRole;
	}

	public void setTargetRole(String targetRole) {
		this.targetRole = targetRole;
	}
	@Override
    public List<String> toRow(List<String> fields) {
		 List<String> row = new ArrayList<>();
		 if (fields.contains("targetRole")) {
			row.add(targetRole);
		}
	        if (fields.contains("Message")) {
				row.add(message);
			}
	        if (fields.contains("date")) {
				row.add(date.toString());
			}

	        return row;
    }
}
