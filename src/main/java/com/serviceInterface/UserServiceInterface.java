package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.User;

public interface UserServiceInterface {
	public  boolean verifyPassword(String enteredPassword, String storedHashedPassword) ;
	public void addUser(User user) throws SQLException, ClassNotFoundException ;
	public boolean updateUser(User user, String columnToUpdate, String newValue) throws SQLException, ClassNotFoundException ;
	public void deleteUser(User user) throws SQLException, ClassNotFoundException ;
	public  void login(String userName, String password) throws SQLException, InterruptedException, ClassNotFoundException ;

	public User getUserById(String userId) throws ClassNotFoundException, SQLException ;
	public List<User> getAllUsers() throws SQLException, ClassNotFoundException ;
	public User getUserByUserName(String userName) throws SQLException, ClassNotFoundException ;
	public  User getUsernameList() throws ClassNotFoundException, SQLException ;
}
