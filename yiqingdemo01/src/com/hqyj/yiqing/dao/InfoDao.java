package com.hqyj.yiqing.dao;

import java.util.List;

import com.hqyj.yiqing.pojo.Info;

public interface InfoDao {

	//�в�
	//ʵ�ֲ�ѯ��������ȷ������
	int selectConfirmAllCount();
	
	//ʵ�ֲ�ѯ������������
	int selectCuredAllCount();
		
	//ʵ�ֲ�ѯ������������
	int selectDeadAllCount();
	
	//�û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������������ͳ��
	Info selectAllCountByPName(String name);//����ʡ������
	
	//��ѯ34��ʡ�е�������������
	List<Info> selectChinaInfo();
	
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	List<Info> selectInfoByName(String name);
	
	//��ʡȷ������ǰ��ĵ���
	List<Info> getConfirmAboutFive(String name);//����ʡ������
	
	//��ʡ��������ǰ��ĵ���
	List<Info> getCuredAboutFive(String name);//����ʡ������
	
	//��ʡ��������ǰ��ĵ���
	List<Info> getDeadAboutFive(String name);//����ʡ������
}
