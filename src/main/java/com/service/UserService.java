package com.service;

import java.sql.SQLException;
import java.util.List;
import com.Model.User;
import com.dao.UserDAO;
import com.util.Helper;

public class UserService {
	public  UserDAO userDAO = new UserDAO();
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
		
			return user;
	}

	public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
		return  userDAO.getAllUsers();
	}
	public boolean updateUser(User user, String columnToUpdate, String newValue) throws SQLException, ClassNotFoundException {
		
		 return userDAO.updateUser(user.getIdUser(), columnToUpdate, newValue);
	}
	public void deleteUser(User user) throws SQLException, ClassNotFoundException {

		userDAO.deleteUser(user.getIdUser());
	}
 
	public  User login(String userName, String password) throws SQLException, ClassNotFoundException {
		 User user = userDAO.getUserByUserName(userName);

         if (user==null) {
        	 return null;  
         }
         return verifyPassword(password, user.getPassword())?user:null ;

	}

	public User getUserById(String userId) throws ClassNotFoundException, SQLException {
		return userDAO.getUserById(userId);
	}

}
