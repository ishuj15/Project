package com.test.services;

import static org.junit.Assert.assertEquals;
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

import com.Model.Alert;
import com.dao.AlertDAO;
import com.service.AlertService;
@ExtendWith(MockitoExtension.class)
public class AlertServiceTest {
	@Mock
	private AlertDAO alertDao;
	@InjectMocks
	private AlertService alertServiceObj;

	@Before
	public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void addAlertTest () throws ClassNotFoundException, SQLException {
		Alert alert= new Alert();
		
		alert.setIdAlert("123");
		alert.setMessage("Earthquake");
		alert.setTargetRole("all");	
		when(alertDao.addAlert(alert)).thenReturn(true);
		
		alertServiceObj.addAlert(alert);
		verify(alertDao, times(1)).addAlert(alert);
	}
	
	
	@Test
	public void updateAlertTest() throws ClassNotFoundException, SQLException {
		String alertId="123";
		String columnToUpdate="targetRole";
		String newValue="all";
		
		when(alertDao.updateAlert(alertId, columnToUpdate, newValue)).thenReturn(true);
		alertServiceObj.updateAlert(alertId, columnToUpdate, newValue);;
		verify(alertDao,times(1)).updateAlert(alertId, columnToUpdate, newValue);
	}
	@Test
	public void deleteAlertTest() throws ClassNotFoundException, SQLException {
		String alertId="123";
		when(alertDao.deleteAlert(alertId)).thenReturn(true);
		 
		alertServiceObj.deleteAlert(alertId);
		verify(alertDao,times(1)).deleteAlert(alertId);	
	}
	@Test 
	public void getAllAlertsTest() throws ClassNotFoundException, SQLException {
		List<Alert> expected=null;
		when(alertDao.getAllAlerts()).thenReturn(expected);
		alertServiceObj.getAllAlerts();
		verify(alertDao,times(1)).getAllAlerts();
	}
	@Test
	public void  getAlertByRoleTest() throws ClassNotFoundException, SQLException {
		List<Alert> expected=null;
		when(alertDao.getAlertByRole("all")).thenReturn(expected);
		alertServiceObj.getAlertByRole("all");
		verify(alertDao,times(1)).getAlertByRole("all");
	}
}
