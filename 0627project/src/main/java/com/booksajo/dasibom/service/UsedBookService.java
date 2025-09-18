package com.booksajo.dasibom.service;

import java.util.ArrayList;
import java.util.List;

import com.booksajo.dasibom.vo.UsedBookVO;



public interface UsedBookService {
	UsedBookVO getUsedBook(int post_Id);
	List<UsedBookVO> getAllUsedBooks();
    ArrayList<UsedBookVO> getUsedBooksByPage(int startRow, int endRow); // ?��?���?
    int getUsedBookCount(); // �? 게시�? ?��
    int insertUsedBook(UsedBookVO vo);  // ?���?
    int updateUsedBook(UsedBookVO vo);  // ?��?��
    int deleteUsedBook(int post_Id);     // ?��?��
}
