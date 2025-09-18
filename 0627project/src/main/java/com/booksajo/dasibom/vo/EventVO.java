package com.booksajo.dasibom.vo;

import java.util.Date;

public class EventVO {
	
	private int event_Id;          // �̺�Ʈ ID
    private String title;          // �̺�Ʈ Ÿ��Ʋ
    private String subtitle;       // ������
    private String description;    // �� ����
    private String image_path;     // �̹��� ���
    private Date start_date;       // ������
    private Date end_date;         // ������
    private Date reg_date;         // �����
    
	public int getEvent_Id() {
		return event_Id;
	}
	public void setEvent_Id(int event_Id) {
		this.event_Id = event_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
    
   
}


