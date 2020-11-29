package com.hqyj.yiqing.pojo;

//Info表的定义类
 
public class Info {
	//对应表的code列
	private int code;
	//对应表的time列
	private String time;
	//对应表的provinceName列
	private String provinceName;
	//对应表的areaName列
	private String areaName;
	//对应表的confirmCount列
	private int confirmCount;
	//对应表的curedCount列
	private int curedCount;
	//对应表的deadCount列
	private int deadCount;
	//对应表的locationId列
	private int locationId;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getConfirmCount() {
		return confirmCount;
	}
	public void setConfirmCount(int confirmCount) {
		this.confirmCount = confirmCount;
	}
	public int getCuredCount() {
		return curedCount;
	}
	public void setCuredCount(int curedCount) {
		this.curedCount = curedCount;
	}
	public int getDeadCount() {
		return deadCount;
	}
	public void setDeadCount(int deadCount) {
		this.deadCount = deadCount;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

}
