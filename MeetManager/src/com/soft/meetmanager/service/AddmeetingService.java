package com.soft.meetmanager.service;

import com.soft.meetmanager.dao.AddmeetingDAO;
import com.soft.meetmanager.model.Meeting;

public class AddmeetingService {

	AddmeetingDAO addao = new AddmeetingDAO();
	public int addmeetig(Meeting metdel){
		int insFlag = 0;
		insFlag = addao.insert(metdel);
		return insFlag;
	}
	
	//ԤԼ����֮ǰ���Ȳ�ѯһ��������Ƿ�ռ��
	public int bookMeetingRoom(Meeting mt){
		int flag = 0;
		flag = addao.bookMeetRoom(mt);
		//���flag����1��˵���������ѱ�ʹ��
		if(flag != 1){
			System.out.println("�������ѱ�ʹ�ã�");
			flag =3 ;
		}else{
			flag = addao.insert(mt);
 		}
		return flag;
	}
}
