package com.service.implementation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.Model.Alert;
import com.dao.implementation.AlertDAO;
import com.daoInterface.AlertInterface;
import com.serviceInterface.AlertServiceInterface;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class AlertService implements AlertServiceInterface  {
	private AlertInterface alertDAO = new AlertDAO();

	public void addAlert(Alert alert) throws SQLException, ClassNotFoundException {
		alertDAO.addAlert(alert);
		Helper.printFunction(str.alertCreatedSuccessfully);

	}

	public void listAlerts(String role) throws SQLException, ClassNotFoundException {
		List<Alert> alerts =  alertDAO.getAlertByRole(role);
		
		if (alerts == null || alerts.isEmpty()) {
			System.out.println(str.alertNotFound);
			return ;

		} else {
			List<String> headers=  Arrays.asList("S.No",  "Message","Date");
			List<String> fields = Arrays.asList("Message","date");
			PrintInTable.printTable(alerts, headers,fields);
		}
	}

	public void listAlerts() throws SQLException, ClassNotFoundException {
		List<Alert> alerts = alertDAO.getAllAlerts();
		if (alerts == null || alerts.isEmpty()) {
			System.out.println(str.alertNotFound);
			return;
		} else {
			List<String> headers=  Arrays.asList("S.No", "Role", "Message","Date");
			List<String> fields = Arrays.asList("Message","targetRole","date");
			PrintInTable.printTable(alerts, headers,fields);
		}
	}

	public void updateAlert(String idAlert, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
		alertDAO.updateAlert(idAlert, ColumnToUpdate, NewValue);
	}

	public void deleteAlert() throws SQLException, ClassNotFoundException {
		
		Alert alert = getAlert();
		if (alert == null) {
			System.out.println(str.alertNotFound);
			return ;
		}
		else
		{
			alertDAO.deleteAlert(alert.getIdAlert());
		System.out.println(str.alertDeleted);
		}
		
	}
	public Alert getAlert() throws ClassNotFoundException, SQLException {

		List<Alert> alerts = alertDAO.getAllAlerts();
		if (alerts == null) {
			System.out.println(str.alertNotFound);
			return null;
		}
		else
		{
		listAlerts();
		System.out.println(str.selectAlert);
		while (true) {
			int choice = Helper.choiceInput(alerts.size());
			return alerts.get(choice - 1);

		}
		}
	}
	
}
