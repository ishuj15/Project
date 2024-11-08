package com.controller;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.Model.User;
import com.service.implementation.UserService;
import com.util.Helper;
import com.util.str;
import com.serviceInterface.UserServiceInterface;

public class UserController {
	//private static Logger logger  = FileLogging.getLogger(UserController.class);
	private static Scanner scanner= new Scanner(System.in);
	public  static  UserServiceInterface userService = new UserService();
	public static void createUser() throws SQLException, ClassNotFoundException {
		String password, userRole, phoneNo, email, userName,address;
		User user = new User();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true) {
			Helper.printFunction(str.enterUserName);
			userName = scanner.nextLine().trim();
			if (Helper.isUsernameValid(userName)  ) {
				if(userService.getUserByUserName(userName)==null)
				{
					break;
				} else {
					System.out.println(str.userNameTaken);
				}
			}
		}
		while (true) {
			System.out.print(str.enterRole);
			userRole = scanner.nextLine().trim();
			if (Helper.isUserRoleValid(userRole.toLowerCase())) {
				break;
			} else {
				System.out.println(str.invalidInput);
			}
		}
		while (true) {
			System.out.print(str.enterPassword);
			password = scanner.nextLine().trim();
			if (Helper.isPasswordValid(password)) {
				break;
			} else {
				System.out.println(str.wrongPassword);
			}
		}
		while (true) {
			System.out.print(str.enterPhoneNo);
			phoneNo = scanner.nextLine().trim();
			if (Helper.isPhoneNumberValid(phoneNo)) {
				break;
			} else {
				System.out.println(str.wrongPhoneNo);
			}
		}
		while (true) {
			System.out.print(str.enterEmail);
			email = scanner.nextLine().trim();
			if (Helper.isEmailValid(email)) {
				break;
			} else {
				System.out.println(str.wrongEmail);
			}

		}
		while (true) {
			System.out.print(str.enterAddress);
		    address = scanner.nextLine().trim();
		    if (Helper.notNullCheck(address)) {
		        break;
		    } else {
				System.out.println(str.wrongAddress);
			}

		}

		String hashedPassword = Helper.hashPassword(password);

		String userId = Helper.generateUniqueId();

		user.setIdUser(userId);
		user.setUserName(userName);
		user.setUserRole(userRole);
		user.setPassword(hashedPassword);
		user.setPhoneNo(phoneNo);
		user.setEmail(email);
		user.setAddress(address);

		userService.addUser(user);
		System.out.println(str.userCreatedSuccessfully);
	}

	public void viewUser(String idUser) throws SQLException, ClassNotFoundException {
		 userService.getUserByUserName(idUser);
	}

	public void listUsers() throws SQLException, ClassNotFoundException {
		userService.getAllUsers();	
	}

	public void updateUser(User user) throws SQLException, ClassNotFoundException {

		System.out.println(str.userUpdateList);
		System.out.println(str.selectUserFieldToUpdate);
		String columnToUpdate = null, newValue = null;
		int	choice = Helper.choiceInput(6);
		switch (choice) {
		case 1: {
			while (true) {
				columnToUpdate =str.userName;
				System.out.print(str.enterUserName);
				newValue = scanner.nextLine();
				if (Helper.isUsernameValid(newValue) )
				{
					if(userService.getUserByUserName(newValue)==null)
					{
						break;
					} else {
						System.out.println(str.userNameTaken);
					}
				}
			}
			break;
		}
		case 2: {
			while (true) {
				columnToUpdate = str.password;
				System.out.print(str.enterPassword);
				newValue = scanner.nextLine();
				if (Helper.isPasswordValid(newValue)) {
					break;
				}
			}
			break;
		}
		case 3: {
			while (true) {
				columnToUpdate = str.phoneNo;
				System.out.print(str.enterPhoneNo);
				newValue = scanner.nextLine();
				if (Helper.isPhoneNumberValid(newValue)) {
					break;
				} else {
					System.out.println(str.wrongPhoneNo);
				}
			}
			break;
		}
		case 4: {
			while (true) {

				columnToUpdate = str.email;
				System.out.print("Enter new email: ");
				newValue = scanner.nextLine();
				if (Helper.isEmailValid(newValue)) {
					break;
				} else {
					System.out.println(str.wrongEmail);
				}
			}
			break;
		}
		case 5: {
			columnToUpdate = str.address;
			while (true) {
				System.out.print(str.enterAddress);
				newValue = scanner.nextLine().trim();
			    if (Helper.notNullCheck(newValue)) {
			        break;
			    } else {
					System.out.println(str.wrongAddress);
				}

			}
			break;
		}
		case 6:
			return;
		case 7:
		{
			scanner.close();
			System.exit(0);
			return;
		}
		default:
			System.out.println(str.invalidInput);
		}
		userService.updateUser(user,columnToUpdate, newValue);
		System.out.println(str.userUpdatedSuccessfully);

	}

	public static  void deleteUser(User user) throws SQLException, ClassNotFoundException {
		userService.deleteUser(user);
	}

	public static void login() throws SQLException, ClassNotFoundException, InterruptedException {

		try {

			System.out.println(str.enterLoginDeatils);
			System.out.println(str.enterUserName);
			
			Console consoleObject= System.console();

			String userName = scanner.nextLine().trim();
			System.out.println(str.enterPassword);

			char[] ch= consoleObject.readPassword();
			String password= String.valueOf(ch);
			//String password = scanner.nextLine().trim();
			userService.login(userName, password);

		} catch (SQLException e) {
			//logger.log(Level.SEVERE, "Login failed due to a database error", e);
		}

	}

	public  static User getUsernameList() throws ClassNotFoundException, SQLException {
		return userService.getUsernameList();
	}

	public User getUserByadmin() throws ClassNotFoundException, SQLException {
		List<User> users = userService.getAllUsers();
		if(users.isEmpty())
		{
			System.out.println(str.noListOfUser);
			return null;
		}
		else {
			listUsers();
			int choice = Helper.choiceInput(users.size());
		User selectedUser = users.get(choice - 1);
		return selectedUser;
		}
	}
}