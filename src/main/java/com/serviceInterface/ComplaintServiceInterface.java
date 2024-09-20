package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Complaint;

public interface ComplaintServiceInterface {
	public void addComplaint(Complaint complaint) throws SQLException, ClassNotFoundException ;
	public List<Complaint> getComplaintsById(String userId) throws SQLException, ClassNotFoundException ;
	public List<Complaint> getAllComplaints() throws SQLException, ClassNotFoundException ;
	public void deleteComplaint(String idComplaint) throws SQLException, ClassNotFoundException ;
	public void updateComplaint(String idComplaint, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException;
}
