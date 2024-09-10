package com.service;

import java.sql.SQLException;
import java.util.List;

import com.Model.Visitor;
import com.dao.VisitorDAO;

public class VisitorService {
	private  VisitorDAO visitorDAO;

	public VisitorService() {
		this.visitorDAO = new VisitorDAO();
	}

	public void addVisitor(Visitor visitor) throws SQLException, ClassNotFoundException {
		
		visitorDAO.addVisitor(visitor);
	}

	public List<Visitor> getVisitorById(String id) throws SQLException, ClassNotFoundException {
		
		return visitorDAO.getVisitorById(id);
	}

	public List<Visitor> getAllVisitors() throws SQLException, ClassNotFoundException {
		return visitorDAO.getAllVisitors();	
	}
	public void updateVisitor(String visitorId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
	
		visitorDAO.updateVisitor(visitorId, ColumnToUpdate, NewValue);
	}
 
	public void deleteVisitor(String visitorId) throws SQLException, ClassNotFoundException {
		
		visitorDAO.deleteVisitor(visitorId);	
	}

	public List<Visitor> getAllPendingReq(String userId, String approvalReq) throws SQLException, ClassNotFoundException {
		return visitorDAO.getAllpendingRequests(userId, approvalReq);
	}		
}
