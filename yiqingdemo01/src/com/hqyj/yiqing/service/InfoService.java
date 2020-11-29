package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.InfoDao;
import com.hqyj.yiqing.pojo.Info;

@Service //��ʦ������
public class InfoService {

	//�������Ӷ��󣬰��кõĲ��ø���ʦ��
	@Autowired//(Autowired���Զ�װ��)
	InfoDao dao;
	
	//����
	public int selectConfirmAllCount(){
		
		return dao.selectConfirmAllCount();
	}
	
	//�����������
	public List<HashMap<String,String>> yiqingfenxi(){
		
		//��ȡȷ�������
		int confirmCount=dao.selectConfirmAllCount();
		//��ȡ��������
		int curedCount=dao.selectCuredAllCount();
		//��ȡ��������
		int deadCount=dao.selectDeadAllCount();
		
		//����һ�����϶���
		List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		//����ȷ������
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name", "����ȷ��");
		map.put("value", confirmCount+"");
		//��ӵ�������
		list.add(map);
		
		//������������
		HashMap<String,String> mapCured=new HashMap<String,String>();
		mapCured.put("name","��������");
		mapCured.put("value", curedCount+"");
		//��ӵ�������
		list.add(mapCured);
		
		//������������
		HashMap<String,String> mapDead=new HashMap<String,String>();
		mapDead.put("name","��������");
		mapDead.put("value", deadCount+"");
		//��ӵ�������
		list.add(mapDead);
		
		return list;
	}
	
	//�û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������������ͳ��
	public List<HashMap<String,String>> selectAllCountByName(String name){
		//��ȡ����ʡ�ݲ�ѯ������
		Info info=dao.selectAllCountByPName(name);
		
		//����һ�����϶���
		List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		//������ʡ��ȷ������
		HashMap<String,String> mapConfirm=new HashMap<String,String>();
		mapConfirm.put("name", "����ȷ��");
		mapConfirm.put("value", info.getConfirmCount()+"");
		list.add(mapConfirm);
		
		//������ʡ����������
		HashMap<String,String> mapCured=new HashMap<String,String>();
		mapCured.put("name", "��������");
		mapCured.put("value", info.getCuredCount()+"");
		list.add(mapCured);
		
		//������ʡ����������
		HashMap<String,String> mapDead=new HashMap<String,String>();
		mapDead.put("name", "��������");
		mapDead.put("value", info.getDeadCount()+"");
		list.add(mapDead);
		
		return list;
	}
	
	//��ѯ34��ʡ�е�������������
	public List<HashMap<String,String>> selectChinaInfo(){
		//����һ�����϶���
		List<HashMap<String,String>> listMap=new ArrayList<HashMap<String,String>>();
		//��ȡ��ѯ������
		List<Info> list=dao.selectChinaInfo();
		//����list����
		for(Info i:list){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name", i.getProvinceName());
			map.put("value", i.getConfirmCount()+"");
			listMap.add(map);
		}
		return listMap;
	}
	
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	public List<HashMap<String,String>> selectInfoByName(String name){
		//����һ�����϶���
		List<HashMap<String,String>> listMap=new ArrayList<HashMap<String,String>>();
		//��ȡ��ѯ������
		List<Info> list=dao.selectInfoByName(name);
		//����list����
		for(Info i:list){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name", i.getAreaName()/* +"��" */);
			map.put("value",i.getConfirmCount()+"");
			listMap.add(map);
		}
		return listMap;
	}
	
	//����34��ʡ���������ĵ�������
	public List<String> loadCity(){
		List<String> list=new ArrayList<String>();
		//��ȡ��ѯ������
		List<Info> listOne=dao.selectChinaInfo();
		//��������
		for(Info i:listOne){
			//��ӵ�������
			list.add(i.getProvinceName());
		}
		return list;
	}
	
	//��ʡȷ������ǰ��ĵ���
	public List<List<String>> getConfirmAboutFive(String name){
		//������ݵļ���
		List<List<String>> listArea=new ArrayList<List<String>>();
		
		List<Info> list=dao.getConfirmAboutFive(name);
		
		List<String> areaName=new ArrayList<String>();
		
		for(Info info:list){
			areaName.add(info.getAreaName());
		}
		
		List<String> confirmPeople =new ArrayList<String>();
		
		for(Info info:list){
			confirmPeople.add(info.getConfirmCount()+"");
		}
		
		listArea.add(areaName);
		listArea.add(confirmPeople);

		return listArea;
	}
	
	//��ʡ��������ǰ��ĵ���
	public List<List<String>> getCuredAboutFive(String name){
		//������ݵļ���
		List<List<String>> listArea=new ArrayList<List<String>>();
		
		List<Info> list=dao.getCuredAboutFive(name);
		
		List<String> areaName=new ArrayList<String>();
		
		for(Info info:list){
			areaName.add(info.getAreaName());
		}
		
		List<String> curedPeople=new ArrayList<String>();
		
		for(Info info:list){
			curedPeople.add(info.getCuredCount()+"");
		}
		
		listArea.add(areaName);
		listArea.add(curedPeople);
		
		return listArea;
	}
	
	//��ʡ��������ǰ��ĵ���
	public List<List<String>> getDeadAboutFive(String name){
		//������ݵļ���
		List<List<String>> listArea =new ArrayList<List<String>>();
		
		List<Info> list=dao.getDeadAboutFive(name);
		
		List<String> areaName=new ArrayList<String>();
		
		for(Info info:list){
			areaName.add(info.getAreaName());
		}
		
		List<String> deadPeople=new ArrayList<String>();
		
		for(Info info:list){
			deadPeople.add(info.getDeadCount()+"");
		}
		
		listArea.add(areaName);
		listArea.add(deadPeople);
		
		return listArea;
	}
}
