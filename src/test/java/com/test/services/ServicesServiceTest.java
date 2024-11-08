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

import com.Model.Services;
import com.dao.implementation.ServicesDAO;
import com.service.implementation.ServicesService;
@ExtendWith(MockitoExtension.class)
class ServicesServiceTest {
	@Mock
	private ServicesDAO servicesDao;
	@InjectMocks
	private ServicesService servicesServiceObj;
	@Before
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addServiceTest() throws ClassNotFoundException, SQLException
	{
		Services service= new Services();
		service.setIdServices("123");
		service.setServiceName("Tffin");
		when(servicesDao.addService(service)).thenReturn(true);
		servicesServiceObj.addService(service);
		verify(servicesDao,times(1)).addService(service);
	}
	@Test
	public void updateServiceTest() throws ClassNotFoundException, SQLException
	{
		String userId="123";
		String columnToUpdate="description";
		String newValue="new Description";
		when(servicesDao.updateService(userId, columnToUpdate, newValue)).thenReturn(true);
		servicesDao.updateService(userId, columnToUpdate, newValue);
		verify(servicesDao,times(1)).updateService(userId, columnToUpdate, newValue);
	}
	@Test
	public void deleteServiceTest() throws ClassNotFoundException, SQLException
	{
		String userId="123";
		when(servicesDao.deleteService(userId)).thenReturn(true);
		servicesServiceObj.deleteService(userId);
		verify(servicesDao,times(1)).deleteService(userId);
	}
	@Test
	public void GetAllServicesTest() throws ClassNotFoundException, SQLException
	{
		List<Services> expected=null;
		when(servicesDao.getAllServices()).thenReturn(expected);
		servicesServiceObj.getAllServices();
		//assertEquals(expected,actual);
		verify(servicesDao, times(1)).getAllServices();
	}
	@Test
	public void getServiceByIdTest() throws ClassNotFoundException, SQLException
	{
		List<Services> expected=null;
		String userId="123";
		when(servicesDao.getServiceById(userId)).thenReturn(expected);
		List<Services> actual = servicesServiceObj.getServiceById(userId);
		assertEquals(expected,actual);
		verify(servicesDao, times(1)).getServiceById(userId);
	}
}
