package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Complaint;

public interface ComplaintServiceInterface {
	public void addComplaint(Complaint complaint) throws SQLException, ClassNotFoundException ;
<<<<<<< HEAD
	public void getComplaintsById(String userId) throws SQLException, ClassNotFoundException ;
	public void getAllComplaints() throws SQLException, ClassNotFoundException ;
	public void deleteComplaint() throws SQLException, ClassNotFoundException ;
=======
	public List<Complaint> getComplaintsById(String userId) throws SQLException, ClassNotFoundException ;
	public List<Complaint> listComplaints() throws SQLException, ClassNotFoundException ;
	public void deleteComplaint(String idComplaint) throws SQLException, ClassNotFoundException ;
>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6
	public void updateComplaint(String idComplaint, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException;
	public Complaint getComplaint() throws ClassNotFoundException, SQLException ;
}
