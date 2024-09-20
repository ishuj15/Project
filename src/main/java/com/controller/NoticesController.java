 package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.serviceInterface.NoticesServiceInterface;

import com.Model.Notices;
import com.service.implementation.NoticesService;
import com.util.Helper;
import com.util.PrintInTable;
import com.util.str;

public class NoticesController {

	Scanner scanner = new Scanner(System.in);
	private final NoticesServiceInterface noticesService = new NoticesService();

	public void createNotice() throws SQLException, ClassNotFoundException {
		String message=null,title=null;
		String targetRole=null;
		while(true)
		{
			System.out.print(str.noticeTitle);
			title = scanner.nextLine().trim();
			if(Helper.notNullCheck(title)) {
				System.out.println(str.notNullNoticeTitle);
			} else {
				break;
			}
		} 
		while(true)
		{
			System.out.println(str.noticeMessage);

			message = scanner.nextLine().trim();
			if(Helper.notNullCheck(message)) {
				System.out.println(str.notNullMessage);
			} else {
				break;
			}
		}

		LocalDate currentDate = LocalDate.now();
		while(true)
		{
			System.out.print(str.alertTargetRole);
			 targetRole = scanner.nextLine().trim().toLowerCase();
			if(Helper.isValidTarget(targetRole)) {
				break;
			}
		}

		String noticeId = Helper.generateUniqueId();

		Notices notice = new Notices();
		notice.setIdNotices(noticeId);
		notice.setTitle(title);
		notice.setMessage(message);
		notice.setDate(currentDate.toString());
		notice.setTargetRole(targetRole);

		noticesService.addNotice(notice);
		System.out.println(str.noticeCreatedSuccefully);
	}

	public void listNotices(String role) throws SQLException, ClassNotFoundException {
		List<Notices> notices = noticesService.getNoticeByRole(role);

		if (notices == null || notices.isEmpty()) {
			System.out.println(str.noticeNotFound);
			return;
		} else {
			List<String> headers= Arrays.asList( "S.No", "Title", "Message", "Date");
			List<String> fields= Arrays.asList(  "title", "message", "date");
			PrintInTable.printTable(notices, headers, fields);
		}
	}

	public void listNotices() throws SQLException, ClassNotFoundException {
		List<Notices> notices = noticesService.getAllNotices();

		if (notices == null || notices.isEmpty()) {
			System.out.println(str.noticeNotFound);
			return;
		} else {
			List<String> headers= Arrays.asList( "S.No", "Title", "Message", "Date", "Role");
			List<String> fields= Arrays.asList(  "title", "message", "date", "targetRole");
			PrintInTable.printTable(notices, headers, fields);
		}
	}

	public void updateNotice() throws SQLException, ClassNotFoundException {
		Notices notice = getNotice();

		if (notice == null)
		{
			System.out.println(str.noticeNotFound);
		}
		else {
			String idNotice = notice.getIdNotices();

			System.out.println(str.noticeUpdateList);
			System.out.println(str.selectUpdate);
			int choice = Helper.choiceInput(5);
			switch (choice) {
			case 1: {
				String title ;
				while(true)
				{
					System.out.print(str.noticeTitle);
					title = scanner.nextLine().trim();
					if(Helper.notNullCheck(title)) {
						break;
					} else {
						System.out.println(str.notNullNoticeTitle);
					}
				}
				noticesService.updateNotice(idNotice, "title", title);
				System.out.println(str.noticeUpdatedSuccessfully);
				break;
			}
			case 2: {
				String message;
				while(true)
				{
					System.out.println(str.noticeMessage);

					message = scanner.nextLine().trim();
					if(Helper.notNullCheck(message)) {
						break;
					} else {
						System.out.println(str.notNullMessage);
					}
				}
				noticesService.updateNotice(idNotice, "message", message);
				System.out.println(str.noticeUpdatedSuccessfully);
				break;
			}
			case 3: {
				String targetRole ;
				while(true)
				{
					System.out.print(str.alertTargetRole);
					 targetRole = scanner.nextLine().trim().toLowerCase();
					if(Helper.isValidTarget(targetRole)) {
						break;
					}

				}
				noticesService.updateNotice(idNotice, "targetRole", targetRole);
				System.out.println(str.noticeUpdatedSuccessfully);
				break;
			}
			case 4: {
				return;
			}
			case 5:
			{
				scanner.close();
				System.exit(0);
				return;
			}
			default:
				System.out.println(str.invalidInput);
			}
		}
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
		noticesService.deleteNotice(notice.getIdNotices());
		System.out.println(str.noticeDeleteSuccessfully);
	}
	}
	public Notices getNotice() throws ClassNotFoundException, SQLException {

		List<Notices> notices = noticesService.getAllNotices();
		if(notices.isEmpty()|| notices.equals(null))
		{
			System.out.println(str.noticeNotFound);

			return null;
		}
		else
		{
		listNotices();
		System.out.println(str.selectNotice);
		int choice = Helper.choiceInput(notices.size());

		return notices.get(choice - 1);
		}
	}
}
