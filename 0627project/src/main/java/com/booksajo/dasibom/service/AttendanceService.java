package com.booksajo.dasibom.service;

import java.util.Date;
import java.util.List;

import com.booksajo.dasibom.vo.DayVO;



public interface AttendanceService {
	
	
    // ���� �⼮ ���� Ȯ��
    boolean isAlreadyChecked(String user_Id, Date today);

    // �⼮ ��� ����
    void insertAttendance(String user_Id, Date today);

    // �̹� �� �� �⼮ �ϼ�
    int countAttendanceThisMonth(String user_Id);

    // �⼮ ��� ���� (��: 30�� �޼� �� ����)
    void resetAttendance(String user_Id);

    // �߰� (�⼮�� Ķ���� �����ֱ��)
    List<List<DayVO>> getCalendarForMonth(String user_Id, int year, int month);

}
