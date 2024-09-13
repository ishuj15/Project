package com.Model;

import java.util.ArrayList;
import java.util.List;

public class Visitor implements ModelInterface {
	private String idVisitor;
	private String userId;
	private String name;
	private String purpose;
	private String arrivalTime;
	private String departureTime;
	private String arrivalDate;
	private String dep_date;
	private String approved;
	private String contactNo;
	 @Override
	    public List<String> toRow(List<String>fields) {
		 List<String> row= new ArrayList<>();
		 if(fields.contains("name")) {
			row.add(name);
		}
		 if(fields.contains("purpose")) {
			row.add(purpose);
		}
		 if(fields.contains("contactNo")) {
			row.add(contactNo);
		}
		 if(fields.contains("Arrival date")) {
			row.add(arrivalDate);
		}
		 if(fields.contains("arrivalTime")) {
			row.add(arrivalTime);
		}
		 if(fields.contains("departure date")) {
			row.add(dep_date);
		}
		 if(fields.contains("departureTime")) {
			row.add(departureTime);
		}
		 if(fields.contains("Status")) {
			row.add(approved);
		}
		 return row;

	    }
	public String getIdVisitor() {
		return idVisitor;
	}

	public void setIdVisitor(String idVisitor) {
		this.idVisitor = idVisitor;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDate() {
		return arrivalDate;
	}

	public void setDate(String date) {
		this.arrivalDate = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String time) {
		this.arrivalTime = time;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String time) {
		this.departureTime = time;
	}

	public String getStatus() {
		return approved;
	}

	public void setStatus(String approved) {
		this.approved = approved;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDep_date() {
		return dep_date;
	}

	public void setDep_date(String dep_date) {
		this.dep_date = dep_date;
	}
}
