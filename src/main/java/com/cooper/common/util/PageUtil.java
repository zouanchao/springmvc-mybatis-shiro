package com.cooper.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageUtil {
	//下一页，默认为第1页
	private Integer nextPage = 1;
	//一页显示记录数，默认为10行
	private Integer pageCount = 10;
	//记录总数
	private long totalCount = 0;
	//搜索条件
	private Map<String, String> map = new HashMap<String, String>();
	
	/******** 分页用的参数，最小行数和最大行数 ********/
	/*
	public Long getLessNum() {
		return (long)(getPageCount() * (getNextPage() -1));
	}
	public Long getMaxNum() {
		return (long)(getPageCount() * (getNextPage() -1) + getPageCount());
	}
	*/
	
	/**
	 * 存放搜索条件
	 * @param title
	 * @param item
	 */
	public void putSearchItem(String title, String item) {
		map.put(title, item);
	}
	/**
	 * 读取搜索条件
	 * @param title
	 * @return
	 */
	public String getSearchItem(String title) {
		return map.get(title);
	}
	
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		if(pageCount == null || pageCount <= 0 || pageCount > 200) pageCount = 1;
		this.pageCount = pageCount;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
}
