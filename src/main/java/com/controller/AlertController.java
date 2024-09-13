package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Model.Alert;
import com.service.AlertService;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;
public class AlertController {
	private AlertService alertService = new AlertService();
	Scanner scanner = new Scanner(System.in);

	public void createAlert() throws SQLException, ClassNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String message=null;
		String targetRole=null;
		while(true)
		{
			Helper.printFunction(str.alertMessage);
			 message = scanner.nextLine();
			if(Helper.notNullCheck(message)) {
				Helper.printFunction(str.notNullMessage);
			} else {
				break;
			}
		}

		LocalDate dateStr = LocalDate.now();
		while(true)
		{
			Helper.printFunction(str.alertTargetRole);
			 targetRole = scanner.nextLine().toLowerCase();
			 if(Helper.isValidTarget(targetRole.toLowerCase().trim())) {
				break;
			} else {
				System.out.println(str.validTargetRole);
			}
		}
		String alertId = Helper.generateUniqueId();
		Alert alert = new Alert();
		alert.setMessage(message);
		alert.setIdAlert(alertId);
		alert.setDate(java.sql.Date.valueOf(dateStr));
		alert.setTargetRole(targetRole);
		alertService.addAlert(alert);
		Helper.printFunction(str.alertCreatedSuccessfully);
	}

	public void viewAlertByRole(String role) throws SQLException, ClassNotFoundException {
		List<Alert> alerts = alertService.getAlertByRole(role);

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
		List<Alert> alerts = alertService.getAllAlerts();

		if (alerts == null || alerts.isEmpty()) {
			System.out.println(str.alertNotFound);
			return;
		} else {
			List<String> headers=  Arrays.asList("S.No", "Role", "Message","Date");
			List<String> fields = Arrays.asList("Message","targetRole","date");
			PrintInTable.printTable(alerts, headers,fields);
		}
	}
	public void updateAlert() throws SQLException, ClassNotFoundException {

			Alert alert = getAlert();
			if (alert == null) {
				System.out.println(str.alertNotFound);
				scanner.close();
				return ;
			} else {
				String idAlert = alert.getIdAlert();

				System.out.println(str.alertUpdateList);
				System.out.println(str.alertUpdatefield);
				int choice = Helper.choiceInput(4);

				switch (choice) {
				case 1: {
					String message ;
					while(true)
					{
						Helper.printFunction(str.alertMessage);
						 message = scanner.nextLine();
						if(Helper.notNullCheck(message)) {
							break;
						} else {
							Helper.printFunction(str.notNullMessage);
						}
					}
					alertService.updateAlert(idAlert, "message", message);
					System.out.println(str.alertUpdated);
					break;
				}
				case 2: {
					String targetRole ;
					while(true)
					{
						Helper.printFunction(str.alertTargetRole);
						 targetRole = scanner.nextLine().trim();
						 if(Helper.isValidTarget(targetRole)) {
							break;
						} else {
							System.out.println(str.validTargetRole);
						}
					}

					alertService.updateAlert(idAlert, "targetRole", targetRole);
					System.out.println(str.alertUpdated);
					break;
				}
				case 3: {
					scanner.close();
					return;
				}
				case 4:
				{
					scanner.close();
					System.exit(0);
					return;
				}
				default:
					System.out.println(str.invalidInput);
				}
				scanner.close();
		}
	}

	public void deleteAlert() throws SQLException, ClassNotFoundException {
		Alert alert = getAlert();
		if (alert == null) {
			System.out.println(str.alertNotFound);
			return ;
		}
		else
		{
		alertService.deleteAlert(alert.getIdAlert());
		System.out.println(str.alertDeleted);
		}
	}

	public Alert getAlert() throws ClassNotFoundException, SQLException {

		List<Alert> alerts = alertService.getAllAlerts();
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
