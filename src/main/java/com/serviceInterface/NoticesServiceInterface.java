package com.serviceInterface;

import java.sql.SQLException;

import com.Model.Notices;

public interface NoticesServiceInterface {
	public void addNotice(Notices notice) throws SQLException, ClassNotFoundException ;
	public void getNoticeByRole(String role) throws SQLException, ClassNotFoundException ;
	public void getAllNotices() throws SQLException, ClassNotFoundException ;
	public void updateNotice(String noticeId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException;
	public void deleteNotice() throws SQLException, ClassNotFoundException ;
	public Notices getNotice() throws ClassNotFoundException, SQLException;
	
}
