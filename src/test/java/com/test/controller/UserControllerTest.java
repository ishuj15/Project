//package com.test.controller;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.sql.SQLException;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.Model.User;
//import com.controller.UserController;
//import com.service.UserService;
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//	@Mock
//	private UserService userService;
//	@InjectMocks
//	private UserController userController;
//	@Before
//	public void setUp()
//	{
//		MockitoAnnotations.openMocks(this);
//
//	}
////	@Test
////	public void createUserTest() throws ClassNotFoundException, SQLException
////	{
////		User user = new User();
////        user.setIdUser("1");
////        user.setUserName("testuser");
////        user.setPassword("hashedpassword");
////        user.setPhoneNo("1234567890");
////        user.setEmail("testuser@test.com");
////        user.setUserRole("resident");
////		//doNothing().when(userService.addUser(user)). 	 	;
////		doNothing().when(userService).addUser(any(User.class));
////		 userController.createUser();
////
////	        // Verify that userService.addUser was called with the correct user
////	        verify(userService, times(1)).addUser(user);
////
////	        // Assert the result
////	      //  assertTrue(result);
////	}
////	@Test
////	public void deleteUserTest() throws ClassNotFoundException, SQLException
////	{
////		User user = new User();
////		user.setUserRole("resident");
////
////		//when(userService.deleteUser(user)).thenReturn(null);
////
////
////		   doNothing().when(userService).deleteUser(user);
////
////	        // Call the delete user method
////	         userController.deleteUser(user);
////
////	        // Verify that the userService.deleteUser was called
////	        verify(userService, times(1)).deleteUser(user);
////
////	        // Assert the result
////	     //   assertTrue(result);
////	}
//}
