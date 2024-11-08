package com.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Model.Visitor;
import com.dao.implementation.VisitorDAO;
import com.service.implementation.VisitorService;
@ExtendWith(MockitoExtension.class)
class VisitorServiceTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Mock
	private VisitorDAO visitorDao;
	@InjectMocks
	private VisitorService visitorServiceObj;
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addVisitorTest() throws ClassNotFoundException, SQLException
	{
		Visitor visitor=new Visitor();
		visitor.setStatus("pending");
		visitor.setName("john");
		visitor.setContactNo("12345678900");

		when(visitorDao.addVisitor(visitor)).thenReturn(true);
		visitorServiceObj.addVisitor(visitor);
		verify(visitorDao, times(1)).addVisitor(visitor);

	}
	@Test
	public void getVisitorByIdTest() throws ClassNotFoundException, SQLException
	{
		String userID="123";
		List<Visitor> expected=null;
		when(visitorDao.getVisitorById(userID)).thenReturn(expected);
		List<Visitor> actual= visitorServiceObj.getVisitorById(userID);
		assertEquals(expected,actual);
		verify(visitorDao, times(1)).getVisitorById(userID);
	}
	@Test
	public void getAllVisitorsTest() throws ClassNotFoundException, SQLException
	{
		List<Visitor> expected=null;
		when(visitorDao.getAllVisitors()).thenReturn(expected);
		List<Visitor> actual= visitorServiceObj.getAllVisitors();
		assertEquals(expected,actual);
		verify(visitorDao, times(1)).getAllVisitors();
	}
	@Test
	public void deleteVisitorTest() throws ClassNotFoundException, SQLException
	{
		String VisitorId="123";
		when(visitorDao.deleteVisitor(VisitorId)).thenReturn(true);
		 visitorServiceObj.deleteVisitor(VisitorId);
		 verify(visitorDao, times(1)).deleteVisitor(VisitorId);
		}


	@Test
	public void updateVisitorTest() throws ClassNotFoundException, SQLException
	{
		String visitorId="123";
		String columnToUpdate="contact";
		String newValue= "1234567888";
		when(visitorDao.updateVisitor(visitorId, columnToUpdate, newValue)).thenReturn(true);
		visitorServiceObj.updateVisitor(visitorId, columnToUpdate, newValue);
		verify(visitorDao, times(1)).updateVisitor(visitorId, columnToUpdate, newValue);
	}
	@Test
	public void getAllPendingReqTest() throws ClassNotFoundException, SQLException
	{
		String userId="123";
		String approvalReq="Pending";
		List<Visitor> expected=null;
		when(visitorDao.getAllpendingRequests(userId, approvalReq)).thenReturn(expected);
		List<Visitor> actual = visitorServiceObj.getAllPendingReq(userId, approvalReq);
		assertEquals(expected,actual);
		verify(visitorDao,times(1)).getAllpendingRequests(userId, approvalReq);
	}



}
