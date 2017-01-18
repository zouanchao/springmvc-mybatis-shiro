/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.cooper.common.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author Administrator
 * @Description Service支持类，所有的Service可继承此Service
 * @Version 1.0
 * @Date 2016年6月27日
 * @param <T>
 */
@Service
public abstract class BaseService<T>  {

	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
		return mapper;
	}

	/**
	 * @Author  author
	 * @Description 添加单个实体
	 * @Version 1.0
	 * @Date 2016年6月21日
	 * @param entity
	 * @return
	 */
	public int save(T entity) {
		return mapper.insert(entity);
	}

	/**
	 * @Author  author
	 * @Description 删除的单个实体
	 * @Version 1.0
	 * @Date 2016年6月27日
	 * @param key
	 * @return
	 */
	public int delete(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/**
	 * @Author  author
	 * @Description 更新单个实体（所有属性）
	 * @Version 1.0
	 * @Date 2016年6月27日
	 * @param entity
	 * @return
	 */
	public int updateAll(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	/**
	 * @Author Administrator
	 * @Description 更新单个实体（部位NULL的属性）
	 * @Version 1.0
	 * @Date 2016年6月27日
	 * @param entity
	 * @return
	 */
	public int updateNotNull(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	/**
	 * @Author Administrator
	 * @Description 根据Example查询
	 * @Version 1.0
	 * @Date 2016年6月27日
	 * @param example
	 * @return
	 */
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	/**
	 * @Author Administrator
	 * @Description 根据主键查询
	 * @Version 1.0
	 * @Date 2016年6月27日
	 * @param key
	 * @return
	 */
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	/** 
	 * @Title: selectAll 
	 * @Description: 查询所有数据
	 * @return  List<T>
	 * @throws 
	 */
	public List<T> selectAll(){
		return mapper.selectAll();
	}

	/** 
	 * @Title: selectOne 
	 * @Author: jackCooperZ
	 * @Description: 返回单个对象
	 * @param record
	 * @return   
	 * @throws 
	 */
	public T selectOne(T record){
		return mapper.selectOne(record);
	}


	//TODO 其他...
}
