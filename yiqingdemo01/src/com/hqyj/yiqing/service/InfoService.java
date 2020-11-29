package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.InfoDao;
import com.hqyj.yiqing.pojo.Info;

@Service //厨师工作服
public class InfoService {

	//创建墩子对象，把切好的菜拿给厨师炒
	@Autowired//(Autowired：自动装配)
	InfoDao dao;
	
	//炒菜
	public int selectConfirmAllCount(){
		
		return dao.selectConfirmAllCount();
	}
	
	//今日疫情分析
	public List<HashMap<String,String>> yiqingfenxi(){
		
		//获取确诊的人数
		int confirmCount=dao.selectConfirmAllCount();
		//获取治愈人数
		int curedCount=dao.selectCuredAllCount();
		//获取死亡人数
		int deadCount=dao.selectDeadAllCount();
		
		//创建一个集合对象
		List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		//构建确诊人数
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name", "现有确诊");
		map.put("value", confirmCount+"");
		//添加到集合中
		list.add(map);
		
		//构建治愈人数
		HashMap<String,String> mapCured=new HashMap<String,String>();
		mapCured.put("name","现有治愈");
		mapCured.put("value", curedCount+"");
		//添加到集合中
		list.add(mapCured);
		
		//构建死亡人数
		HashMap<String,String> mapDead=new HashMap<String,String>();
		mapDead.put("name","现有死亡");
		mapDead.put("value", deadCount+"");
		//添加到集合中
		list.add(mapDead);
		
		return list;
	}
	
	//用户选择的省份查询该省的现有确诊，现有治愈，现有死亡的统计
	public List<HashMap<String,String>> selectAllCountByName(String name){
		//获取根据省份查询的数据
		Info info=dao.selectAllCountByPName(name);
		
		//创建一个集合对象
		List<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		//构建各省的确诊人数
		HashMap<String,String> mapConfirm=new HashMap<String,String>();
		mapConfirm.put("name", "现有确诊");
		mapConfirm.put("value", info.getConfirmCount()+"");
		list.add(mapConfirm);
		
		//构建各省的治愈人数
		HashMap<String,String> mapCured=new HashMap<String,String>();
		mapCured.put("name", "现有治愈");
		mapCured.put("value", info.getCuredCount()+"");
		list.add(mapCured);
		
		//构建各省的死亡人数
		HashMap<String,String> mapDead=new HashMap<String,String>();
		mapDead.put("name", "现有死亡");
		mapDead.put("value", info.getDeadCount()+"");
		list.add(mapDead);
		
		return list;
	}
	
	//查询34个省市地区的疫情数据
	public List<HashMap<String,String>> selectChinaInfo(){
		//创建一个集合对象
		List<HashMap<String,String>> listMap=new ArrayList<HashMap<String,String>>();
		//获取查询的数据
		List<Info> list=dao.selectChinaInfo();
		//遍历list集合
		for(Info i:list){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name", i.getProvinceName());
			map.put("value", i.getConfirmCount()+"");
			listMap.add(map);
		}
		return listMap;
	}
	
	//根据省份名称查询该省的所有地区的疫情信息
	public List<HashMap<String,String>> selectInfoByName(String name){
		//创建一个集合对象
		List<HashMap<String,String>> listMap=new ArrayList<HashMap<String,String>>();
		//获取查询的数据
		List<Info> list=dao.selectInfoByName(name);
		//遍历list集合
		for(Info i:list){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name", i.getAreaName()/* +"市" */);
			map.put("value",i.getConfirmCount()+"");
			listMap.add(map);
		}
		return listMap;
	}
	
	//加载34个省市自治区的地区名称
	public List<String> loadCity(){
		List<String> list=new ArrayList<String>();
		//获取查询的数据
		List<Info> listOne=dao.selectChinaInfo();
		//遍历集合
		for(Info i:listOne){
			//添加地区名称
			list.add(i.getProvinceName());
		}
		return list;
	}
	
	//各省确诊人数前五的地区
	public List<List<String>> getConfirmAboutFive(String name){
		//存放数据的集合
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
	
	//各省治愈人数前五的地区
	public List<List<String>> getCuredAboutFive(String name){
		//存放数据的集合
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
	
	//各省死亡人数前五的地区
	public List<List<String>> getDeadAboutFive(String name){
		//存放数据的集合
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
