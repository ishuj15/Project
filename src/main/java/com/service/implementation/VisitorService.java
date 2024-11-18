package com.service.implementation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.Model.User;
import com.Model.Visitor;
import com.controller.UserController;
import com.dao.implementation.VisitorDAO;
import com.daoInterface.VisitorInterface;
import com.serviceInterface.VisitorServiceInterface;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class VisitorService  implements VisitorServiceInterface {
	private  VisitorInterface visitorDAO;

	public VisitorService() {
		this.visitorDAO = new VisitorDAO();
	}

	public void addVisitor(Visitor visitor) throws SQLException, ClassNotFoundException {

		visitorDAO.addVisitor(visitor);
	}

	public List<Visitor> getAllVisitorsByUserId(String id) throws SQLException, ClassNotFoundException {

		List<Visitor> visitors = visitorDAO.getVisitorById(id);
		if (visitors == null || visitors.isEmpty()) {
			System.out.println(str.visitorNotFound);
			return null ;
		} else {

			List<String> headers=  Arrays.asList("S.No", "Name", "Contact", "Purpose","Arrival Date", "Arrival Time", "Departure Date",  "Departure Time","Approval Req");
			List<String> fields = Arrays.asList("name","contactNo","purpose","Arrival date","arrivalTime","departure date","departureTime","Status");
			PrintInTable.printTable(visitors, headers,fields);
		}
		return visitors;
		// Hello ishu
	}

	public List<Visitor> getAllVisitors() throws SQLException, ClassNotFoundException {
		List<Visitor>visitors= visitorDAO.getAllVisitors();
		if (visitors == null || visitors.isEmpty()) {
			System.out.println(str.visitorNotFound);
			return null;

		} else {
//			List<String> headers=  Arrays.asList("S.No", "Name", "Contact","Arrival Date", "Purpose", "Arrival Time", "Departure Time", "Departure Date", "Approval Req");
//			List<String> fields = Arrays.asList("name","purpose","arrivalTime","departureTime","Arrival date","departure date","Status","contactNo");
//			PrintInTable.printTable(visitors, headers,fields);
			System.out.printf("%-5s %-10s %-15s %-15s %-20s %-20s %-20s %-15s %-15s %-15s\n", "S.No", "Name", "Contact",
					"Arrival Date", "Purpose", "Arrival Time", "Departure Time", "Departure Date", "Status","UserName");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------"
							+ "------------------------------------------------------");
			int serialNumber = 1;

			for (Visitor visitor : visitors) {
				User user= UserController.userService.getUserById(visitor.getUserId());
				System.out.printf("%-5d %-10s %-15s %-15s %-20s %-20s %-20s %-15s %-15s %-15s\n", serialNumber++,
						visitor.getName(), visitor.getContactNo(), visitor.getDate(),
						visitor.getPurpose(), visitor.getArrivalTime(), visitor.getDepartureTime(),
						visitor.getDep_date(), visitor.getStatus(),user.getUserName());
			}
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------"
							+ "------------------------------------------------------");
		}
		
		return visitors;

	}
	public void updateVisitor(String visitorId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {

		visitorDAO.updateVisitor(visitorId, ColumnToUpdate, NewValue);
	}

	public void deleteVisitor(String visitorId) throws SQLException, ClassNotFoundException {

		visitorDAO.deleteVisitor(visitorId);
	}

	public void getAllPendingReq(String userId, String approvalReq) throws SQLException, ClassNotFoundException {
		List<Visitor> visitors = visitorDAO.getAllpendingRequests(userId, approvalReq);
		if (visitors == null || visitors.isEmpty()) {
			System.out.println(str.visitorNotFound);
			return ;
		} else {

			List<String> headers=  Arrays.asList("S.No", "Name", "Contact","Purpose","Arrival Date",  "Arrival Time",  "Departure Date","Departure Time", "Approval Req");
			List<String> fields = Arrays.asList("name","contactNo","purpose","Arrival date","arrivalTime","departure date","departureTime","Status");
			PrintInTable.printTable(visitors, headers,fields);
			System.out.println(str.selectToDenyOrApprove);

			int choice = Helper.choiceInput(visitors.size());

			Visitor selectedVisitor = visitors.get(choice - 1);
			String visitorId = selectedVisitor.getIdVisitor();

			System.out.println(str.selectToApprove);
			System.out.println(str.selectToDeny);

				int choice2 = Helper.choiceInput(2);

			if (choice2 == 1) {
				updateVisitor(visitorId, "approvalReq",str.approved );
				System.out.println(str.requestApproved);
			} else {
				updateVisitor(visitorId, "approvalReq",str.rejected );
				System.out.println(str.requestDenied);
			}
		}
	}
}
