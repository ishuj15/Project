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
		complaintService.getAllComplaints();
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

	public void deleteComplaintAdmin() throws SQLException, ClassNotFoundException {
		
		complaintService.deleteComplaint();
		System.out.println(str.complaintDeleted);
	}
}
