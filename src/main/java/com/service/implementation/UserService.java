package com.service.implementation;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Model.User;
import com.dao.implementation.UserDAO;
import com.daoInterface.UserInterface;
import com.serviceInterface.UserServiceInterface;
import com.societyManagement.main.AdminMenu;
import com.societyManagement.main.GuardMenu;
import com.societyManagement.main.ResidentMenu;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class UserService implements UserServiceInterface {
	public  UserInterface userDAO = new UserDAO();
	//private static Logger logger = FileLogging.getLogger(UserController.class);

	public  boolean verifyPassword(String enteredPassword, String storedHashedPassword) {

		String hashedEnteredPassword = Helper.hashPassword(enteredPassword);
		return hashedEnteredPassword.equals(storedHashedPassword);
	}
	public void addUser(User user) throws SQLException, ClassNotFoundException {
		userDAO.addUser(user);
	}

	public User getUserByUserName(String userName) throws SQLException, ClassNotFoundException {
		User user=userDAO.getUserByUserName(userName);
			if (user != null) {
				System.out.println("-----------------------------------------------------");
				System.out.printf("| %-15s | %-30s |\n", "Field", "Value");
				System.out.println("-----------------------------------------------------");

				System.out.printf("| %-15s | %-30s |\n", "User Name", user.getUserName());
				System.out.printf("| %-15s | %-30s |\n", "User Role", user.getUserRole());
				System.out.printf("| %-15s | %-30s |\n", "Phone No", user.getPhoneNo());
				System.out.printf("| %-15s | %-30s |\n", "Email", user.getEmail());
				System.out.printf("| %-15s | %-30s |\n", "Address", user.getAddress());

				System.out.println("------------------------------------------------------");
			} else {
				System.out.println(str.userNotFound);
				return null;
			}
			return user;
	}

	public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
		List<User> users=  userDAO.getAllUsers();
		
		if (users == null || users.isEmpty()) {
			System.out.println(str.userNotFound);
			return null ;
		}
		else
		{
		List<String> headers= Arrays.asList( "S.No", "User Name","User Role", "Phone No","Email","Address");
		List<String> fields= Arrays.asList(  "userName", "userRole", "phoneNo", "email","address");
		PrintInTable.printTable(users, headers, fields);
		}
		return users;
	}
	public boolean updateUser(User user, String columnToUpdate, String newValue) throws SQLException, ClassNotFoundException {

		 return userDAO.updateUser(user.getIdUser(), columnToUpdate, newValue);
	}
	public void deleteUser(User user) throws SQLException, ClassNotFoundException {

		if (user.getUserRole().toLowerCase().equals(str.admin)) {
			System.out.println(str.NoadminDeletion);
			return;
		}

		else {
			userDAO.deleteUser(user.getIdUser());
		
			System.out.println(str.UserdeletedSuccessfully);
		}
	}

	public  void login(String userName, String password) throws SQLException, ClassNotFoundException, InterruptedException {
		 User user = userDAO.getUserByUserName(userName);

         if (user==null || !verifyPassword(password, user.getPassword())) {
        	
        	 System.out.println(str.invalidUserNameOrPassword);
        	 return ;
      //logger.warning("Failed login attempt for username: " + userName);

         }
         else
         {
        	// logger.info("User logged in: " + user.getUserName());
	        	System.out.println( str.loginSuccessful+ user.getUserName() + ".");
	        	  if(user.getUserRole().toLowerCase().equals(str.resident))
		            {
		            	ResidentMenu obj= new ResidentMenu();
		    			//Console consoleObject= System.console();

		    			//consoleObject.flush();
//		    			for (int i = 0; i < 100; i++) {
//		    	            System.out.println();
//		    	        }
		            	obj.displayMenu(user);
		            }
		            else if(user.getUserRole().toLowerCase().equals(str.guard)) {
		            	GuardMenu guardMenu =new GuardMenu();
		            	guardMenu.displayMenu(user);
		            }
		            else
		            {
		            	AdminMenu adminMenuObj= new AdminMenu();
		            	adminMenuObj.displayMenu(user);
		            }
         }
	}

	public User getUserById(String userId) throws ClassNotFoundException, SQLException {
		return userDAO.getUserById(userId);
	}
	public  User getUsernameList() throws ClassNotFoundException, SQLException {
		List<User> users = userDAO.getAllUsers();
		List<User> userOfResident= new ArrayList<>();
		int serialNumber=1;
		if (users == null || users.isEmpty()) {
			System.out.println(str.userNotFound);
			return null;
		} else {
//			List<String> headers= Arrays.asList( "S.No", "User Name");
//			List<String> fields= Arrays.asList(  "userName");
//			PrintInTable.printTable(users, headers, fields);
//
			System.out.printf("| %-5s | %-20s |\n", "S.No", "Username");
			System.out.println("|-------|----------------------|");

			for (User user : users) {
				if(user.getUserRole().equals("resident"))
				{
					userOfResident.add(user);
					System.out.printf("| %-5d | %-20s |\n", serialNumber++, user.getUserName());
				}

			}
			System.out.println("|-------|----------------------|");
		}
		int choice = Helper.choiceInput(serialNumber);
		User selectedUser = userOfResident.get(choice - 1);
		return selectedUser;
	}

}
