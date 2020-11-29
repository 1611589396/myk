package com.hqyj.yiqing.dao;

import java.util.List;

import com.hqyj.yiqing.pojo.Info;

public interface InfoDao {

	//切菜
	//实现查询今日现有确诊人数
	int selectConfirmAllCount();
	
	//实现查询现有治愈人数
	int selectCuredAllCount();
		
	//实现查询现有死亡人数
	int selectDeadAllCount();
	
	//用户选择的省份查询该省的现有确诊，现有治愈，现有死亡的统计
	Info selectAllCountByPName(String name);//传入省份名称
	
	//查询34个省市地区的疫情数据
	List<Info> selectChinaInfo();
	
	//根据省份名称查询该省的所有地区的疫情信息
	List<Info> selectInfoByName(String name);
	
	//各省确诊人数前五的地区
	List<Info> getConfirmAboutFive(String name);//传入省份名称
	
	//各省治愈人数前五的地区
	List<Info> getCuredAboutFive(String name);//传入省份名称
	
	//各省死亡人数前五的地区
	List<Info> getDeadAboutFive(String name);//传入省份名称
}
