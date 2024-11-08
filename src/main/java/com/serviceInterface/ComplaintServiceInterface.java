package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Complaint;

public interface ComplaintServiceInterface {
	public void addComplaint(Complaint complaint) throws SQLException, ClassNotFoundException ;
	public void getComplaintsById(String userId) throws SQLException, ClassNotFoundException ;
	public void getAllComplaints() throws SQLException, ClassNotFoundException ;
	public void deleteComplaint() throws SQLException, ClassNotFoundException ;
	public void updateComplaint(String idComplaint, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException;
	public Complaint getComplaint() throws ClassNotFoundException, SQLException ;
}
