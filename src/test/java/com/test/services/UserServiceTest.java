package com.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Model.User;
import com.dao.implementation.UserDAO;
import com.service.implementation.UserService;
import com.util.Helper;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	@Mock
	private UserDAO userDao;
	@InjectMocks
	private UserService userServiceobj;

	@Before
	public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	public void addUser() throws ClassNotFoundException, SQLException
	{
		User user = new User();
        user.setIdUser("1234");
        user.setUserName("testUser1");
        user.setUserRole("resident");
        user.setPassword("hashedPassword");
        user.setPhoneNo("1234567890");
        user.setEmail("test@test.com");
        user.setAddress("Test Address");

        when(userDao.addUser(user)).thenReturn(true);
        userServiceobj.addUser(user);
        verify(userDao, times(1)).addUser(user);
	}
	@Test
	public void deleteUser() throws ClassNotFoundException, SQLException
	{
		User user = new User();
		user.setIdUser("123");
		when(userDao.deleteUser(user.getIdUser())).thenReturn(true);
		userServiceobj.deleteUser(user);

	}
	@Test
	public void updateUser() throws ClassNotFoundException, SQLException
	{
		User user = new User();
		user.setIdUser("1234");
		String columnToUpdate="address";
		String newValue="param";
		when(userDao.updateUser(user.getIdUser(), columnToUpdate, newValue)).thenReturn(true);
		userServiceobj.updateUser(user, columnToUpdate, newValue);

	}
	@Test
	public void getAllUsers() throws ClassNotFoundException, SQLException
	{
		 List<User> expected = null;

	        when(userDao.getAllUsers()).thenReturn(expected);

	        List<User> actual = userServiceobj.getAllUsers();

	        assertEquals(expected, actual);

	}
	@Test
	public void loginUserSuccess() throws ClassNotFoundException, SQLException
	{
		String userName="ishuj";
		String password="Password123@";
		String hashedPassword= Helper.hashPassword(password);
		User user= new User();
		user.setUserName(userName);
		user.setPassword(hashedPassword);

		when(userDao.getUserByUserName(userName)).thenReturn(user);

		User loggedIn= userServiceobj.login(userName, password);

		assertEquals(userName, loggedIn.getUserName());


	}
	@Test
	public void verifyPasswordTrue()
	{
		String enteredPassword="Password123@";
		String hashedPassword=Helper.hashPassword(enteredPassword);
		boolean result= userServiceobj.verifyPassword(enteredPassword, hashedPassword);
		assertTrue("Password should match", result);

	}
	@Test
	public void getUserByIdTest() throws ClassNotFoundException, SQLException
	{
		String userId="123";
		User user= new User();
		user.setIdUser(userId);
		when(userDao.getUserById(userId)).thenReturn(user);

		User actualUser= userServiceobj.getUserById(userId);
		assertEquals(user,actualUser);
	}

	@Test
	public void getUserByUserName() throws ClassNotFoundException, SQLException
	{
		 User expectedUser= new User();
		 expectedUser.setUserName("ishuj");
		 expectedUser.setPhoneNo("1234567808");
		 expectedUser.setAddress("Paramount floraville");
		 expectedUser.setUserRole("resident");
		 expectedUser.setEmail("ishuj123@gmail.com");
		 expectedUser.setIdUser("72a8ea1ee91f");
		 expectedUser.setPassword("d85fb61a933e0b8a45f88c89888502573a3d318657a576ef5529bf948b98882c");

		when(userDao.getUserByUserName("ishuj")).thenReturn(expectedUser);

		User actualUser= userServiceobj.getUserByUserName("ishuj") ;
		assertNotNull("User should not be null", actualUser);

		assertEquals(expectedUser.getUserName(), actualUser.getUserName());
        assertEquals(expectedUser.getPhoneNo(), actualUser.getPhoneNo());
        assertEquals(expectedUser.getAddress(), actualUser.getAddress());
        assertEquals(expectedUser.getUserRole(), actualUser.getUserRole());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        assertEquals(expectedUser.getIdUser(), actualUser.getIdUser());
        assertEquals(expectedUser.getPassword(), actualUser.getPassword());
      verify(userDao, times(1)).getUserByUserName("ishuj");

	}

}
