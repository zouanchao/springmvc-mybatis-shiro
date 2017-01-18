package com.cooper.common.util.ace;

import java.util.List;

/**  
 * Copyright © 2016 com. All rights reserved.
 *
 * @Title: DatatablesViewPage.java
 * @Prject: jseasite
 * @Package: com.jseasite.common.util.ace
 * @Description: DataTables 工具类
 * @author: JackCooperZ  
 * @date: 2016年12月2日 上午11:35:50
 * @version: V1.0  
 *
 * @param <T> 
 */
public class DatatablesViewPage<T> {
	
	private List<T> aaData; //aaData 与datatales 加载的“dataSrc"对应  
	
	private int iDisplayStart;//分页开始位置
	
	private Long iTotalDisplayRecords; //分页结束位置
	
	private Long iTotalRecords;  //总记录数
	
	private int iDisplayLength;//分页显示多少条
	
	private String sEcho;//Datatables搜索key
	
	private String sSearch;//搜索关键字
	
	public DatatablesViewPage() {  

	}
	public DatatablesViewPage(List<T> aaData, Long iTotalDisplayRecords,
			Long iTotalRecords,int iDisplayStart, String sEcho) {
		super();
		this.aaData = aaData;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.iTotalRecords = iTotalRecords;
		this.iDisplayStart = iDisplayStart;
		this.sEcho = sEcho;
	}
	
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}  
	
}
