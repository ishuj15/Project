package com.service.implementation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.Model.Notices;
import com.dao.implementation.NoticesDAO;
import com.daoInterface.NoticeInterface;
import com.serviceInterface.NoticesServiceInterface;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class NoticesService implements NoticesServiceInterface {
	private NoticeInterface noticesDAO;
	public NoticesService() {
		this.noticesDAO = new NoticesDAO();
	}
	public void addNotice(Notices notice) throws SQLException, ClassNotFoundException {
		noticesDAO.addNotice(notice);
	}
	public void getNoticeByRole(String role) throws SQLException, ClassNotFoundException {
		List<Notices> notices = noticesDAO.getNoticeByRole(role);

		if (notices == null || notices.isEmpty()) {
			System.out.println(str.noticeNotFound);
			return;
		} else {
			List<String> headers= Arrays.asList( "S.No", "Title", "Message", "Date");
			List<String> fields= Arrays.asList(  "title", "message", "date");
			PrintInTable.printTable(notices, headers, fields);
		}
	}
	public void getAllNotices() throws SQLException, ClassNotFoundException {
		List<Notices> notices =noticesDAO.getAllNotices();
		
		if (notices == null || notices.isEmpty()) {
			System.out.println(str.noticeNotFound);
			return;
		} else {
			List<String> headers= Arrays.asList( "S.No", "Title", "Message", "Date", "Role");
			List<String> fields= Arrays.asList(  "title", "message", "date", "targetRole");
			PrintInTable.printTable(notices, headers, fields);
		}
	}
	public void updateNotice(String noticeId, String ColumnToUpdate, String NewValue)
			throws SQLException, ClassNotFoundException {
		noticesDAO.updateNotice(noticeId, ColumnToUpdate, NewValue);
	}
	public void deleteNotice() throws SQLException, ClassNotFoundException {
		
		Notices notice = getNotice();
		if( notice==null)
		{
			System.out.println(str.noticeNotFound);
			return ;
		}
		else
		{
			noticesDAO.deleteNotice(notice.getIdNotices());

		System.out.println(str.noticeDeleteSuccessfully);
	}		
	}
	public Notices getNotice() throws ClassNotFoundException, SQLException {

		List<Notices> notices = noticesDAO.getAllNotices();
		if(notices.isEmpty()|| notices.equals(null))
		{
			System.out.println(str.noticeNotFound);
			return null;
		}
		else
		{
		getAllNotices();
		System.out.println(str.selectNotice);
		int choice = Helper.choiceInput(notices.size());

		return notices.get(choice - 1);
		}
	}
}