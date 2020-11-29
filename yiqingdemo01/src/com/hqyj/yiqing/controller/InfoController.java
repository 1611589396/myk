package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hqyj.yiqing.service.InfoService;

//服务员（控制层定义的类）
@Controller 				//注解，工作员服装，(Controller:控制器)
@RequestMapping("xiaoming") //注解，服务员的名字 (RequestMapping:请求映射)
public class InfoController {
	
	//创建一个厨师对象，炒好的菜，服务员来端
	@Autowired//相当于new操作，框架中的spring做这件事
	InfoService service;
	
	//端菜行为-->统计新冠肺炎确诊人数
	@RequestMapping("hongshaorou.do")//本框架必须用.do结尾，框架配置决定，也可以是其他
	@ResponseBody   				 //获取数据给顾客(ResponseBody:响应体)
	public int selectConfirmAllCount(){//查询当日新冠肺炎累计确诊总人数
		
		return service.selectConfirmAllCount();
	}
	
	@RequestMapping("yiqingfenxi.do")
	@ResponseBody //端菜给顾客
	public List<HashMap<String,String>> yiqingfenxi(){
		return service.yiqingfenxi();
	}
	
	
	//用户选择的省份查询该省的现有确诊，现有治愈，现有死亡的统计
	@RequestMapping("selectAllCountByName.do")
	@ResponseBody
	public List<HashMap<String,String>> selectAllCountByName(String name){
		return service.selectAllCountByName(name);
	}
	
	//查询34个省市地区的疫情数据
	@RequestMapping("selectChinaInfo.do")
	@ResponseBody //端菜给顾客
	public List<HashMap<String,String>> selectChinaInfo(){
		return service.selectChinaInfo();
	}
	
	//根据省份名称查询该省的所有地区的疫情信息
	@RequestMapping("selectInfoByName.do")
	@ResponseBody //端菜给顾客
	public List<HashMap<String,String>> selectInfoByName(String name){
		return service.selectInfoByName(name);
	}
	
	//加载34个省市自治区的地区名称
	@RequestMapping("loadCity.do")
	@ResponseBody //端菜给顾客
	public List<String> loadCity(){
		return service.loadCity();
	}
	
	//各省确诊人数前五的地区
	@RequestMapping("getConfirmAboutFive.do")
	@ResponseBody //端菜给顾客
	public List<List<String>> getConfirmAboutFive(String name){
		return service.getConfirmAboutFive(name);
	}
	
	//各省治愈人数前五的地区
	@RequestMapping("getCuredAboutFive.do")
	@ResponseBody //端菜给顾客
	public List<List<String>> getCuredAboutFive(String name){
		return service.getCuredAboutFive(name);
	}
	
	//各省死亡人数前五的地区
	@RequestMapping("getDeadAboutFive.do")
	@ResponseBody //端菜给顾客
	public List<List<String>> getDeadAboutFive(String name){
		return service.getDeadAboutFive(name);
	}
}
