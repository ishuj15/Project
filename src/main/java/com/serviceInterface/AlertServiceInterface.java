package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Alert;

public interface AlertServiceInterface {
	public void addAlert(Alert alert) throws SQLException, ClassNotFoundException ;
	public void listAlerts(String role) throws SQLException, ClassNotFoundException ;
	public void listAlerts() throws SQLException, ClassNotFoundException ;
	public void updateAlert(String idAlert, String ColumnToUpdate, String NewValue) 
			throws SQLException, ClassNotFoundException;
	public void deleteAlert() throws SQLException, ClassNotFoundException ;
	
	public Alert getAlert() throws ClassNotFoundException, SQLException;

}
