package com.test.services;


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

import com.Model.Complaint;
import com.dao.implementation.ComplaintDAO;
import com.service.implementation.ComplaintService;

@ExtendWith(MockitoExtension.class)
class ComplaintServiceTest {

	@Mock
	private ComplaintDAO complaintDao;
	@InjectMocks
	private ComplaintService complaintServiceObj;
	@Before
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addComplaintTest() throws ClassNotFoundException, SQLException
	{
		Complaint complaint= new Complaint();
		complaint.setDescription("water leak");
		complaint.setIdComplaint("123");
		complaint.setUserId("456");
		complaint.setStatus("Unresolved");
		complaint.setDate(null);
		when(complaintDao.addComplaint(complaint)).thenReturn(true);
		complaintServiceObj.addComplaint(complaint);
		verify(complaintDao, times(1)).addComplaint(complaint);

	}
	@Test
	public void getComplaintsByIdTest() throws ClassNotFoundException, SQLException
	{
		String userId="123";
		List<Complaint> expected=null;
		when(complaintDao.getComplaintById(userId)).thenReturn(expected);
		complaintServiceObj.getComplaintsById(userId);
		verify(complaintDao,times(1)).getComplaintById(userId);
	}
	@Test
	public void getAllComplaintTest() throws ClassNotFoundException, SQLException
	{
		List<Complaint> expected=null;
		when(complaintDao.getAllComplaints()).thenReturn(expected);
		complaintServiceObj.getAllComplaints();
		verify(complaintDao,times(1)).getAllComplaints();
	}
	@Test
	public void deleteComplaint() throws ClassNotFoundException, SQLException
	{
		String idComplaint="123";
		when(complaintDao.deleteComplaint(idComplaint)).thenReturn(true);
		complaintServiceObj.deleteComplaint(idComplaint);
		verify(complaintDao, times(1)).deleteComplaint(idComplaint);

	}
	@Test
	public void updateComplaint() throws ClassNotFoundException, SQLException
	{
		String idComplaint="123";
		String columnToUpdate="status";
		String newValue="resolved";
		when(complaintDao.updateComplaint(idComplaint, columnToUpdate, newValue)).thenReturn(true);
		complaintServiceObj.updateComplaint(idComplaint, columnToUpdate, newValue);
		verify(complaintDao,times(1)).updateComplaint(idComplaint, columnToUpdate, newValue);
	}

}
