package com.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Services  implements ModelInterface{
	private String idServices;
	private String userId;
	private String serviceName;
	private String description;
	private String status;
	 @Override
	    public List<String> toRow(List<String> fields) {
		 List<String> row= new ArrayList<>();
		 if(fields.contains("serviceName")) row.add(serviceName);
		 if(fields.contains("description")) row.add(description);
		 if(fields.contains("status")) row.add(status);
		 return row;
	       
	    } 
	// Getters and Setters
	public String getIdServices() {
		return idServices;
	}

	public void setIdServices(String idServices) {
		this.idServices = idServices;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
