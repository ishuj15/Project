package com.controller;
import com.serviceInterface.ComplaintServiceInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Model.Complaint;
import com.Model.User;
import com.service.implementation.ComplaintService;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class ComplaintController {
	private ComplaintServiceInterface complaintService = new ComplaintService();
	Scanner scanner = new Scanner(System.in);

	public void createComplaint(User user) throws SQLException, ClassNotFoundException {
		String description=null;
		LocalDate currentDate = LocalDate.now();
		while(true)
		{
			System.out.print(str.enterComplaintDescription);
			description = scanner.nextLine();
			if(Helper.notNullCheck(description)) {
				break;
			} else {
				System.out.println(str.notNullComplaint);
			}
		}
		String status = str.pending;
		String idComplaint = Helper.generateUniqueId();
		Complaint complaint = new Complaint();
		complaint.setUserId(user.getIdUser());
		complaint.setIdComplaint(idComplaint);
		complaint.setDescription(description);
		complaint.setDate(java.sql.Date.valueOf(currentDate));
		complaint.setStatus(status);
		complaintService.addComplaint(complaint);
		System.out.println(str.complaintCreated);
	}

	public void viewComplaint(User user) throws SQLException, ClassNotFoundException {
		complaintService.getComplaintsById(user.getIdUser());
	}
	public void listComplaints() throws SQLException, ClassNotFoundException {
<<<<<<< HEAD
		complaintService.getAllComplaints();
=======
		List<Complaint> complaints = complaintService.listComplaints();
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
>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6
	}

	public void updateComplaint() throws SQLException, ClassNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Complaint complaint = complaintService.getComplaint();
		if (complaint == null)
		{
			System.out.println(str.complaintNotFound);
		return;}
		else {
			String idComplaint = complaint.getIdComplaint();

			System.out.println(str.complaintUpdateList);
			System.out.println(str.complaintTobeUpdated);
			int choice = Helper.choiceInput(3);

			switch (choice) {

			case 1: {
				String status=null;
				while(true)
				{
					System.out.println(str.enterStatus);
					status = scanner.nextLine();
					if(Helper.ComplaintStatus(status) ) {
						break;
					} else {
						Helper.printFunction(str.notNullStatus);
					}

				}
				complaintService.updateComplaint(idComplaint, "status", status);
				System.out.println(str.complaintUpdated);
				break;
			}
			case 2:
				return;
			case 3:
			{
				scanner.close();
				System.exit(0);
				return;
			}
			default:

				System.out.println(str.invalidInput);
			}
		}
	}
<<<<<<< HEAD
=======
	public void deleteComplaint(String userId) throws SQLException, ClassNotFoundException {
		List<Complaint> complaints = complaintService.getComplaintsById(userId);
		 if(complaints.equals(null) || complaints.isEmpty())
		 {
			 System.out.println(str.complaintNotFound);
			 return;
		 }
		 else
		 {
		System.out.println(str.complaintToBeDeleted);
		listComplaints();
		int choice =  Helper.choiceInput(complaints.size());
		Complaint selectedComplaint = complaints.get(choice - 1);
		String idComplaint = selectedComplaint.getIdComplaint();
		complaintService.deleteComplaint(idComplaint);
		System.out.println(str.complaintDeleted);
	}
	}
	public Complaint getComplaint() throws ClassNotFoundException, SQLException {
		List<Complaint> complaints = complaintService.listComplaints();
		 if(complaints.equals(null) || complaints.isEmpty())
		 {
			 System.out.println(str.complaintNotFound);
			 return null;
		 }
		 else
		 {
		listComplaints();
		System.out.println(str.selectComplaint);
		int choice = Helper.choiceInput(complaints.size());
		return complaints.get(choice - 1);
		 }
		 }
>>>>>>> ac87088cf150d40ca3353aac3d1ea1f36ac98ad6

	public void deleteComplaintAdmin() throws SQLException, ClassNotFoundException {
		
		complaintService.deleteComplaint();
		System.out.println(str.complaintDeleted);
	}
}
