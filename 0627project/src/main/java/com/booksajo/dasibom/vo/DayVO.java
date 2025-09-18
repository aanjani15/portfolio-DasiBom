package com.booksajo.dasibom.vo;

import java.util.Date;

public class DayVO {
    private int day;        // 1, 2, 3... or 0 (��ĭ)
    private boolean checked; // �⼮ ���� (true/false)
    private boolean today;	//���� ����

    public DayVO(int day, boolean checked) {
        this.day = day;
        this.checked = checked;
        this.today = false;
    }

    public DayVO(int day, boolean checked, boolean today) {
        this.day = day;
        this.checked = checked;
        this.today = today;
    }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
    
    public boolean isToday() { return today; }   // EL���� ${day.isToday} ��� ����
    public boolean getToday() { return today; }   // ${day.today} ����, ��Ĺ ȣȯ��
    public void setToday(boolean today) { this.today = today; }

}
