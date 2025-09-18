package com.booksajo.dasibom.service;

import java.util.Date;
import java.util.List;

import com.booksajo.dasibom.vo.CouponVO;


public interface CouponService {

	// �⼮ 10�� ���� �߱�
    void issueCoupon(String user_Id, int discountPercent);

    // ���� ��� ��ȸ (ex. �������������� ���)
    List<CouponVO> getUserCoupons(String user_Id);

    // ���� ��� ó��
    void useCoupon(int coupon_Id);
}
