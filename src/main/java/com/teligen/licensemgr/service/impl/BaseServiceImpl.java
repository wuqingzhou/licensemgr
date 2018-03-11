package com.teligen.licensemgr.service.impl;


import com.teligen.licensemgr.base.dao.MyMapper;
import com.teligen.licensemgr.service.BaseService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private MyMapper<T> mapper;

	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	@Override
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}
	
	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}
	
	@Override
	public List<T> selectByIds(String ids) {
		return mapper.selectByIds(ids);
	}
	
	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}
	
	@Override
	public int insert(T record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}
	
	@Override
	public int insertList(List<T> recordList) {
		return mapper.insertList(recordList);
	}
	
	@Override
	public int delete(T record) {
		return mapper.delete(record);
	}
	
	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}
	
	@Override
	public int deleteByIds(String ids) {
		return mapper.deleteByIds(ids);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<T> selectByCondition(Object condition){
		return mapper.selectByCondition(condition);
	}
	
	@Override
	public int selectCountByCondition(Object condition){
		return mapper.selectCountByCondition(condition);
	}

	@Override
	public int updateByCondition(@Param("record") T record, @Param("example") Object condition){
		return mapper.updateByCondition(record, condition);
	}

	@Override
	public int updateByConditionSelective(@Param("record") T record, @Param("example") Object condition){
		return mapper.updateByConditionSelective(record, condition);
	}

	@Override
	public int deleteByCondition(Object condition){
		return mapper.deleteByCondition(condition);
	}
	
	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds){
		return mapper.selectByRowBounds(record, rowBounds);
	}
	
	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds){
		return mapper.selectByExampleAndRowBounds(example, rowBounds);
	}
}
