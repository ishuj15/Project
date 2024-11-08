 package com.service.implementation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.Model.Services;
import com.dao.implementation.ServicesDAO;
import com.daoInterface.ServiceInterface;
import com.serviceInterface.ServicesServiceInterface;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class ServicesService implements ServicesServiceInterface {
	private  ServiceInterface servicesDAO;

	public ServicesService() {
		this.servicesDAO = new ServicesDAO();
	}

	public void addService(Services service) throws SQLException, ClassNotFoundException {
		servicesDAO.addService(service);
	}

	public List<Services> getServiceById(String idUser) throws SQLException, ClassNotFoundException {

		List<Services> services = servicesDAO.getServiceById(idUser);
		if (services.isEmpty() || services==null) {
			System.out.println(str.serviceNotFound);
		return null;
		}
		else {
			List<String> headers= Arrays.asList( "S.No", "Service Name","Description", "Status");
			List<String> fields= Arrays.asList(  "serviceName", "description", "status");
			PrintInTable.printTable(services, headers, fields);

		}
		return services;
	}

	public void getAllServices() throws SQLException, ClassNotFoundException {
		List<Services> services = servicesDAO.getAllServices();
		
		if ( services.isEmpty() ||services.equals(null)) {
			System.out.println(str.serviceNotFound);
			return;
		}
		else {
			List<String> headers= Arrays.asList( "S.No", "Service Name","Description", "Status");
			List<String> fields= Arrays.asList(  "serviceName", "description", "status");
			PrintInTable.printTable(services, headers, fields);

		}
	}

	public void updateService(String serviceId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
		servicesDAO.updateService(serviceId, ColumnToUpdate, NewValue);
	}

	public void deleteService(String id) throws SQLException, ClassNotFoundException {
		servicesDAO.deleteService(id);
	}
	public Services getService() throws ClassNotFoundException, SQLException {
		List<Services> services = servicesDAO.getAllServices();
		if (services.equals(null))
		{
			System.out.println(str.serviceNotFound);
			return null;
		}
		else
		{
		getAllServices();
		System.out.println(str.selectService);
			int choice = Helper.choiceInput(services.size());
		return services.get(choice - 1);
		}
	}
}
