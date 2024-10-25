
package com.societyManagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.controller.UserController;
import com.util.Helper;
import com.util.MovingAlertThread;
import com.util.str;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				Helper.printFunction(str.welcomeMessage);
				Helper.printFunction(str.mainMenu);
				int choice =  Helper.choiceInput(3);
				switch (choice) {
				case 1-> UserController.createUser();
				case 2->UserController.login();
					
				case 3-> {
					scanner.close();
					System.exit(0);
					return;
				} 
				default->
					Helper.printFunction(str.invalidInput);
				}
			}
		} catch (Exception e) {
			Helper.printFunction(str.invalidInput);
		}
	}
}
