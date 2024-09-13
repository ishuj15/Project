package com.presentation.admin.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.Model.User;
import com.controller.ServicesController;
import com.util.Helper;
import com.util.str;

public class ServicesManagementAdmin {
	private Scanner scanner;
	private ServicesController servicesController;

	public ServicesManagementAdmin() {
		this.servicesController = new ServicesController();
		this.scanner = new Scanner(System.in);
	}

	public boolean displayMenu(User user) throws ClassNotFoundException, SQLException, InterruptedException {
		while (true) {
			Helper.printFunction(str.adminService);

				int choice= Helper.choiceInput(5);

			switch (choice) {
			case 1: {
				servicesController.listServices();
				break;
			}
			case 2: {
				servicesController.deleteServiceByAdmin();
				break;
			}
			case 3:
				return true;
			case 4: {

				return false;
			}
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
