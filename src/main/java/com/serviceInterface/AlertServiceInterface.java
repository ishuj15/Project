package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Alert;

public interface AlertServiceInterface {
	public void addAlert(Alert alert) throws SQLException, ClassNotFoundException ;
	public List<Alert> getAlertByRole(String role) throws SQLException, ClassNotFoundException ;
	public List<Alert> getAllAlerts() throws SQLException, ClassNotFoundException ;
	public void updateAlert(String idAlert, String ColumnToUpdate, String NewValue) 
			throws SQLException, ClassNotFoundException;
	public void deleteAlert(String idAlert) throws SQLException, ClassNotFoundException ;

}
