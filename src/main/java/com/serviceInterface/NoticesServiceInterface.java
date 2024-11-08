package com.serviceInterface;

import java.sql.SQLException;
import java.util.List;

import com.Model.Notices;

public interface NoticesServiceInterface {
	public void addNotice(Notices notice) throws SQLException, ClassNotFoundException ;
	public List<Notices> getNoticeByRole(String role) throws SQLException, ClassNotFoundException ;
	public List<Notices> getAllNotices() throws SQLException, ClassNotFoundException ;
	public void updateNotice(String noticeId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException;
	public void deleteNotice(String id) throws SQLException, ClassNotFoundException ;
	
}
