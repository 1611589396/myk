package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hqyj.yiqing.service.InfoService;

//����Ա�����Ʋ㶨����ࣩ
@Controller 				//ע�⣬����Ա��װ��(Controller:������)
@RequestMapping("xiaoming") //ע�⣬����Ա������ (RequestMapping:����ӳ��)
public class InfoController {
	
	//����һ����ʦ���󣬳��õĲˣ�����Ա����
	@Autowired//�൱��new����������е�spring�������
	InfoService service;
	
	//�˲���Ϊ-->ͳ���¹ڷ���ȷ������
	@RequestMapping("hongshaorou.do")//����ܱ�����.do��β��������þ�����Ҳ����������
	@ResponseBody   				 //��ȡ���ݸ��˿�(ResponseBody:��Ӧ��)
	public int selectConfirmAllCount(){//��ѯ�����¹ڷ����ۼ�ȷ��������
		
		return service.selectConfirmAllCount();
	}
	
	@RequestMapping("yiqingfenxi.do")
	@ResponseBody //�˲˸��˿�
	public List<HashMap<String,String>> yiqingfenxi(){
		return service.yiqingfenxi();
	}
	
	
	//�û�ѡ���ʡ�ݲ�ѯ��ʡ������ȷ���������������������ͳ��
	@RequestMapping("selectAllCountByName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectAllCountByName(String name){
		return service.selectAllCountByName(name);
	}
	
	//��ѯ34��ʡ�е�������������
	@RequestMapping("selectChinaInfo.do")
	@ResponseBody //�˲˸��˿�
	public List<HashMap<String,String>> selectChinaInfo(){
		return service.selectChinaInfo();
	}
	
	//����ʡ�����Ʋ�ѯ��ʡ�����е�����������Ϣ
	@RequestMapping("selectInfoByName.do")
	@ResponseBody //�˲˸��˿�
	public List<HashMap<String,String>> selectInfoByName(String name){
		return service.selectInfoByName(name);
	}
	
	//����34��ʡ���������ĵ�������
	@RequestMapping("loadCity.do")
	@ResponseBody //�˲˸��˿�
	public List<String> loadCity(){
		return service.loadCity();
	}
	
	//��ʡȷ������ǰ��ĵ���
	@RequestMapping("getConfirmAboutFive.do")
	@ResponseBody //�˲˸��˿�
	public List<List<String>> getConfirmAboutFive(String name){
		return service.getConfirmAboutFive(name);
	}
	
	//��ʡ��������ǰ��ĵ���
	@RequestMapping("getCuredAboutFive.do")
	@ResponseBody //�˲˸��˿�
	public List<List<String>> getCuredAboutFive(String name){
		return service.getCuredAboutFive(name);
	}
	
	//��ʡ��������ǰ��ĵ���
	@RequestMapping("getDeadAboutFive.do")
	@ResponseBody //�˲˸��˿�
	public List<List<String>> getDeadAboutFive(String name){
		return service.getDeadAboutFive(name);
	}
}
