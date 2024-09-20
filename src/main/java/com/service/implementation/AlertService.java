package com.service.implementation;

import java.sql.SQLException;
import java.util.List;

import com.Model.Alert;
import com.dao.implementation.AlertDAO;
import com.daoInterface.AlertInterface;
import com.serviceInterface.AlertServiceInterface;

public class AlertService implements AlertServiceInterface  {
	private AlertInterface alertDAO = new AlertDAO();

	public void addAlert(Alert alert) throws SQLException, ClassNotFoundException {
		alertDAO.addAlert(alert);
	}

	public List<Alert> getAlertByRole(String role) throws SQLException, ClassNotFoundException {
		return alertDAO.getAlertByRole(role);
	}

	public List<Alert> getAllAlerts() throws SQLException, ClassNotFoundException {
		return alertDAO.getAllAlerts();
	}

	public void updateAlert(String idAlert, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
		alertDAO.updateAlert(idAlert, ColumnToUpdate, NewValue);
	}

	public void deleteAlert(String idAlert) throws SQLException, ClassNotFoundException {
		alertDAO.deleteAlert(idAlert);
	}
}
