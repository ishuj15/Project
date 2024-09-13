package com.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Complaint implements ModelInterface {
	private String idComplaint;
	private String userId;
	private String description;
	private Date date;
	private String status;
	 @Override
	    public List<String> toRow(List<String> fields) {
		 List<String> row= new ArrayList<>();
		 if(fields.contains("description")) {
			row.add(description);
		}
		 if(fields.contains("date")) {
			row.add(date.toString());
		}
		 if(fields.contains("status")) {
			row.add(status);
		}
		 return row;

	    }
	// Getters and Setters
	public String getIdComplaint() {
		return idComplaint;
	}

	public void setIdComplaint(String idComplaint) {
		this.idComplaint = idComplaint;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId2) {
		this.userId = userId2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
