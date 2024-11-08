package com.presentarion.resident.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.Model.User;
import com.controller.AlertController;
import com.util.Helper;
import com.util.str;

public class AlertMenu {
	private final AlertController alertController;
	private Scanner scanner;

	public AlertMenu() {
		this.alertController = new AlertController();
		this.scanner = new Scanner(System.in);
	}

	public boolean displayMenu(User user) throws SQLException, ClassNotFoundException {
		while (true) {

			Helper.printFunction(str.userAlert);

			int choice = Helper.choiceInput(5);

			switch (choice) {
			case 1: {
				alertController.listAlerts(user.getUserRole());
				break;
			}
			case 2:
				return true;
			case 3:
				return false;
			case 4: {
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
