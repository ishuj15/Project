package com.presentarion.resident.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.Model.Complaint;
import com.Model.User;
import com.controller.ComplaintController;
import com.util.Helper;
import com.util.str;

public class ComplaintMenu {
	private final Scanner scanner;
	private final ComplaintController complaintController;

	public ComplaintMenu() {
		this.complaintController = new ComplaintController();
		this.scanner = new Scanner(System.in);
	}

	public boolean displayMenu(User user) throws SQLException, ClassNotFoundException {
		while (true) {
			//System.out.println("Complaint Menu");
			Helper.printFunction(str.userComplaint);
		
			
				int choice = Helper.choiceInput(5);
				

			switch (choice) {
			case 1: {
				
				complaintController.createComplaint(user);
				break;
			}
			case 2: {
				complaintController.viewComplaint(user);
				break;
			}
			case 3:
				return true;
			case 4:
				return false;
			case 5: {
				scanner.close();
				System.exit(0);
				return false;
			}
			default:
				Helper.printFunction(str.invalidInput);
			}
		}
	}
}