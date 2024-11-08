package com.service.implementation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.Model.Complaint;
import com.dao.implementation.ComplaintDAO;
import com.daoInterface.ComplaintInterface;
import com.serviceInterface.ComplaintServiceInterface;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class ComplaintService  implements ComplaintServiceInterface{
	private ComplaintInterface complaintDAO = new ComplaintDAO();

	public void addComplaint(Complaint complaint) throws SQLException, ClassNotFoundException {
		complaintDAO.addComplaint(complaint);
	}

	public void getComplaintsById(String userId) throws SQLException, ClassNotFoundException {
		List<Complaint> complaints =complaintDAO.getComplaintById(userId);
		
		 if(complaints.equals(null) || complaints.isEmpty())
		 {
			 System.out.println(str.complaintNotFound);
			 return;
		 }
		 else
		 {
			 List<String> headers= Arrays.asList("S.No","Description", "Status", "Date");
				List<String> fields= Arrays.asList("description", "status", "date");
				PrintInTable.printTable(complaints, headers, fields);
	}	
	}

<<<<<<< HEAD
	public void getAllComplaints() throws SQLException, ClassNotFoundException {
		
		
		List<Complaint> complaints = complaintDAO.getAllComplaints();
		
		if (complaints.isEmpty()) {
			System.out.println(str.complaintNotFound);
		return ;
		} else {
			List<String> headers= Arrays.asList("S.No","Description", "Status", "Date");
			List<String> fields= Arrays.asList("description", "status", "date");
			PrintInTable.printTable(complaints, headers, fields);
//			System.out.printf("%-5s %-15s %-20s %-15s %-15s%n", "No.", , );
//			System.out.println("---------------------------------------------------------------------------------");
//
//			int serialNumber = 1;
//			for (Complaint complaint : complaints) {
//
//				User user = UserController.userService.getUserById(complaint.getUserId());
//
//				System.out.printf("%-5d %-15s %-20s %-15s %-15s%n", serialNumber++, complaint.getDescription(),
//						complaint.getStatus(), complaint.getDate().toString(),
//						user.getUserName());
//				System.out.println("---------------------------------------------------------------------------------");
//			}

		}
		
		
=======
	public List<Complaint> listComplaints() throws SQLException, ClassNotFoundException {
		return complaintDAO.getAllComplaints();
>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6
	}

	public void deleteComplaint() throws SQLException, ClassNotFoundException {
		
		List<Complaint> complaints = complaintDAO.getAllComplaints();
		 if(complaints.equals(null) || complaints.isEmpty())
		 {
			 System.out.println(str.complaintNotFound);
			 return;
		 }
		 else
		 {
		
		List<String> headers= Arrays.asList("S.No","Description", "Status", "Date");
		List<String> fields= Arrays.asList("description", "status", "date");
		PrintInTable.printTable(complaints, headers, fields);
		int choice =  Helper.choiceInput(complaints.size());
		Complaint selectedComplaint = complaints.get(choice - 1);
		String idComplaint = selectedComplaint.getIdComplaint();
		complaintDAO.deleteComplaint(idComplaint);
	
		System.out.println(str.complaintDeleted);
	}
		
	}

	public void updateComplaint(String idComplaint, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
		complaintDAO.updateComplaint(idComplaint, ColumnToUpdate, NewValue);
	}
	public Complaint getComplaint() throws ClassNotFoundException, SQLException {
		List<Complaint> complaints = complaintDAO.getAllComplaints();
		 if(complaints.equals(null) || complaints.isEmpty())
		 {
			 System.out.println(str.complaintNotFound);
			 return null;
		 }
		 else
		 {
		getAllComplaints();
		System.out.println(str.selectComplaint);
		int choice = Helper.choiceInput(complaints.size());
		return complaints.get(choice - 1);
		 }
		 }
}
