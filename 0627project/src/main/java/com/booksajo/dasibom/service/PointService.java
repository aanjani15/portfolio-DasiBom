package com.booksajo.dasibom.service;

import java.util.Date;
import java.util.List;

import com.booksajo.dasibom.vo.PointVO;


public interface PointService {
	
	
	 // ����Ʈ ����
    void addPoint(String user_Id, int point, String description);

    // ����Ʈ ���
    void usePoint(String user_Id, int point, String description);

    // ���� �� ����Ʈ ��ȸ
    int getTotalPoint(String user_Id);

    // ����Ʈ ���� ��ȸ
    List<PointVO> getPointHistory(String user_Id);
    
    void updateUserPoint(String user_Id, int point);

}
