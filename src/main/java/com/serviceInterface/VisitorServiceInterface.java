package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Visitor;

public interface VisitorServiceInterface {
	public void addVisitor(Visitor visitor) throws SQLException, ClassNotFoundException ;
	public List<Visitor> getAllVisitorsByUserId(String id) throws SQLException, ClassNotFoundException ;
	public List<Visitor> getAllVisitors() throws SQLException, ClassNotFoundException ;
	public void updateVisitor(String visitorId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException ;
	public void deleteVisitor(String visitorId) throws SQLException, ClassNotFoundException ;
	public void getAllPendingReq(String userId, String approvalReq) throws SQLException, ClassNotFoundException ;


}
