package com.Model;

import java.util.ArrayList;
import java.util.List;

public class User implements ModelInterface {
	private String idUser;
	private String userName;
	private String userRole;
	private String password;
	private String phoneNo;
	private String email;
	private String address;
	 @Override
	    public List<String> toRow(List<String> fields) {
		 List<String> row = new ArrayList<>();
		 if(fields.contains("userName")) {
			row.add(userName);
		}
		 if(fields.contains("userRole")) {
			row.add(userRole);
		}
		 if(fields.contains("password")) {
			row.add(password);
		}
		 if(fields.contains("phoneNo")) {
			row.add(phoneNo);
		}
		 if(fields.contains("email")) {
			row.add(email);
		}
		 if(fields.contains("address")) {
			row.add(address);
		}
		 return row;
	    }

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
