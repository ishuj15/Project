package com.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.serviceInterface.ServicesServiceInterface;

import com.Model.Services;
import com.Model.User;
import com.service.implementation.ServicesService;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class ServicesController {
	Scanner scanner = new Scanner(System.in);

	private final ServicesServiceInterface servicesService = new ServicesService();

	public void createService(User user) throws SQLException, ClassNotFoundException {

		System.out.println(str.enterServiceName);
		String name = scanner.nextLine();
		System.out.print(str.enterServiceDescription);
		String description = scanner.nextLine();
		System.out.print(str.enterCurrentStatus);
		String status = scanner.nextLine();

		Services service = new Services();
		service.setIdServices(Helper.generateUniqueId());
		service.setUserId(user.getIdUser());
		service.setServiceName(name);
		service.setDescription(description);
		service.setStatus(status);
		servicesService.addService(service);
		System.out.println(str.serviceCreatedSuccessfully);
	}

	public void viewService(String idUser) throws SQLException, ClassNotFoundException {

		 servicesService.getServiceById(idUser);
	}

	public void listServices() throws SQLException, ClassNotFoundException {
		 servicesService.getAllServices();
		
	}

	public void updateService(String idUser) throws SQLException, ClassNotFoundException {

		List<Services> service = servicesService.getServiceById(idUser);
		if (service.equals(null))
		{
			System.out.println(str.serviceNotFound);
			return;
		}
		else
		{
		viewService(idUser);
		System.out.println(str.selectServiceToModify);
		int choice = Helper.choiceInput(service.size());

		Services selectedService = service.get(choice - 1);
		if (selectedService.equals(null)) {
			System.out.println(str.serviceNotFound);
		} else {
			System.out.println(str.serviceUpdateList);
			System.out.println(str.serviceToBeUpdated);
			int choice2  = Helper.choiceInput(4);

			switch (choice2) {
			case 1: {
				System.out.print(str.enterServiceName);
				String name = scanner.nextLine();
				servicesService.updateService(selectedService.getIdServices(), "serviceName", name);
				System.out.println();
				break;
			}
			case 2: {
				System.out.print(str.enterServiceDescription);
				String description = scanner.nextLine();
				servicesService.updateService(selectedService.getIdServices(), "description", description);
				System.out.println(str.serviceUpadtedSuccessfully);
				break;
			}
			case 3: {
				System.out.print(str.enterCurrentStatus);
				String status = scanner.nextLine();
				servicesService.updateService(selectedService.getIdServices(), "status", status);
				System.out.println(str.serviceUpadtedSuccessfully);
				break;
			}

			case 4:
				return;
			case 5:{
				scanner.close();
				System.exit(0);
				return;
			}
			default:
				System.out.println(str.invalidInput);
			}

		}}
	}

	public void deleteService(String idUser) throws SQLException, ClassNotFoundException {
		List<Services> service = servicesService.getServiceById(idUser);
		if (service.equals(null))
		{
			System.out.println(str.serviceNotFound);
			return;
		}
		else
		{
		System.out.println(str.selectServiceThatNeedToBeDeleted);
		viewService(idUser);
		int choice = Helper.choiceInput(service.size());
		Services selectedService = service.get(choice - 1);
		servicesService.deleteService(selectedService.getIdServices());
		System.out.println(str.serviceDeleted);
		}
	}

	public void deleteServiceByAdmin() throws SQLException, ClassNotFoundException {
		Services service = servicesService.getService();
		if (service.equals(null))
		{
			System.out.println(str.serviceNotFound);
			return ;
		}
		else
		{
		servicesService.deleteService(service.getIdServices());
		System.out.println(str.serviceDeleted);
		}
	}

	
}
