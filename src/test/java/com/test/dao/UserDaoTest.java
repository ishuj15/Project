package com.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Model.User;
import com.dao.UserDAO;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {
	@InjectMocks
	private UserDAO userDao;
	@Mock
	private Connection connection;
	@Mock
	private PreparedStatement preparedStatement;
	@Mock
	private ResultSet resultSet;
	@BeforeEach
	public void setUp() throws SQLException
	{
		MockitoAnnotations.openMocks(this);
		when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
	}
	@Test
	public void addUserTest() throws ClassNotFoundException, SQLException
	{
		User user= new User();
		user.setIdUser("123");
		user.setEmail("ish123@gmail.com");
		user.setAddress("param");
		user.setPhoneNo("1234567890");
		user.setUserName("ish");
		user.setUserRole("resident");
		user.setPassword("123edcd2");
		
		when(preparedStatement.executeQuery()).thenReturn(resultSet);
		 
		boolean result = userDao.addUser(user);
 
		assertTrue(result);
		verify(preparedStatement).executeQuery();
	}
	  @Test
	    public void testGetUserById() throws SQLException, ClassNotFoundException {
	        when(resultSet.next()).thenReturn(true);
	        when(resultSet.getString("idUser")).thenReturn("1");
	        when(resultSet.getString("userName")).thenReturn("john_doe");
	        when(resultSet.getString("userRole")).thenReturn("resident");
	        when(resultSet.getString("password")).thenReturn("password");
	        when(resultSet.getString("phoneNo")).thenReturn("1234567890");
	        when(resultSet.getString("email")).thenReturn("john@example.com");
	        when(resultSet.getString("address")).thenReturn("123 Main St");

	        when(preparedStatement.executeQuery()).thenReturn(resultSet);

	        User result = userDao.getUserById("1");

	        assertNotNull(result);
	        assertEquals("1", result.getIdUser());
	        assertEquals("john_doe", result.getUserName());
	        assertEquals("resident", result.getUserRole());
	        assertEquals("password", result.getPassword());
	        assertEquals("1234567890", result.getPhoneNo());
	        assertEquals("john@example.com", result.getEmail());
	        assertEquals("123 Main St", result.getAddress());
	    }
	    @Test
	    public void testGetAllUsers() throws SQLException, ClassNotFoundException {
	        List<User> userList = new ArrayList<>();
	        User user1 = new User();
	        user1.setIdUser("1");
	        user1.setUserName("john_doe");
	        user1.setUserRole("resident");
	        user1.setPassword("password");
	        user1.setPhoneNo("1234567890");
	        user1.setEmail("john@example.com");
	        user1.setAddress("123 Main St");

	        User user2 = new User();
	        user2.setIdUser("2");
	        user2.setUserName("jane_doe");
	        user2.setUserRole("guard");
	        user2.setPassword("password2");
	        user2.setPhoneNo("0987654321");
	        user2.setEmail("jane@example.com");
	        user2.setAddress("456 Elm St");

	        userList.add(user1);
	        userList.add(user2);

	        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
	        when(resultSet.getString("idUser")).thenReturn("1").thenReturn("2");
	        when(resultSet.getString("userName")).thenReturn("john_doe").thenReturn("jane_doe");
	        when(resultSet.getString("userRole")).thenReturn("resident").thenReturn("guard");
	        when(resultSet.getString("password")).thenReturn("password").thenReturn("password2");
	        when(resultSet.getString("phoneNo")).thenReturn("1234567890").thenReturn("0987654321");
	        when(resultSet.getString("email")).thenReturn("john@example.com").thenReturn("jane@example.com");
	        when(resultSet.getString("address")).thenReturn("123 Main St").thenReturn("456 Elm St");

	        when(preparedStatement.executeQuery()).thenReturn(resultSet);

	        List<User> result = userDao.getAllUsers();

	        assertNotNull(result);
	        assertEquals(2, result.size());
	        assertEquals("1", result.get(0).getIdUser());
	        assertEquals("2", result.get(1).getIdUser());
	    }
	    @Test
	    public void testUpdateUser() throws SQLException, ClassNotFoundException {
	        when(preparedStatement.executeUpdate()).thenReturn(1);

	        boolean result = userDao.updateUser("1", "userName", "john_updated");

	        assertTrue(result);
	        verify(preparedStatement).executeUpdate();
	    }
	    @Test
	    public void testDeleteUser() throws SQLException, ClassNotFoundException {
	        when(preparedStatement.executeUpdate()).thenReturn(1);

	        boolean result = userDao.deleteUser("1");

	        assertTrue(result);
	        verify(preparedStatement).executeUpdate();
	    }
}
