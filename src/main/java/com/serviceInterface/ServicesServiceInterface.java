package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Services;

public interface ServicesServiceInterface {
	public void addService(Services service) throws SQLException, ClassNotFoundException ;
	public List<Services> getServiceById(String idUser) throws SQLException, ClassNotFoundException ;
	public List<Services> getAllServices() throws SQLException, ClassNotFoundException ;
	public void updateService(String serviceId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException ;
	public void deleteService(String id) throws SQLException, ClassNotFoundException ;
	
}
