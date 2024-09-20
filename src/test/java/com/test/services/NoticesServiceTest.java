package com.test.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Model.Notices;
import com.dao.implementation.NoticesDAO;
import com.service.implementation.NoticesService;
@ExtendWith(MockitoExtension.class)
public class NoticesServiceTest {
	@Mock
	private NoticesDAO noticesDao;
	@InjectMocks
	private NoticesService noticeServiceObj;
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addNoticeTest() throws ClassNotFoundException, SQLException {
		Notices notice= new Notices();
		notice.setIdNotices("123");
		notice.setDate(null);
		notice.setMessage("hi");
		notice.setTargetRole("all");
		notice.setTitle("Notice");
		when(noticesDao.addNotice(notice)).thenReturn(true);
		noticeServiceObj.addNotice(notice);
		verify(noticesDao, times(1)).addNotice(notice);
		}
	@Test
	public void getNoticeByRole() throws ClassNotFoundException, SQLException {
		String role="all";
		List<Notices> expected=null;
		when(noticesDao.getNoticeByRole(role)).thenReturn(expected);
		noticeServiceObj.getNoticeByRole(role);
		verify(noticesDao, times(1)).getNoticeByRole(role);
	}
	@Test
	public void getAllNotices() throws ClassNotFoundException, SQLException {
		List<Notices> expected=null;
		when(noticesDao.getAllNotices()).thenReturn(expected);
		noticeServiceObj.getAllNotices();
		verify(noticesDao, times(1)).getAllNotices();
	}
	@Test
	public void updateNotice() throws ClassNotFoundException, SQLException {
		String noticeId="123";
		String coumnToUpdate="message";
		String newValue= "Yoo";
		when(noticesDao.updateNotice(noticeId, coumnToUpdate, newValue)).thenReturn(true);
		noticeServiceObj.updateNotice(noticeId, coumnToUpdate, newValue);
		verify(noticesDao, times(1)).updateNotice(noticeId, coumnToUpdate, newValue);
	}
	@Test
	public void deleteNoticeTest() throws ClassNotFoundException, SQLException {
		String noticeId="123";
		when(noticesDao.deleteNotice(noticeId)).thenReturn(true);
		noticeServiceObj.deleteNotice(noticeId);
		verify(noticesDao, times(1)).deleteNotice(noticeId);
	}

}
