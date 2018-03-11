package com.teligen.licensemgr.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;



public interface BaseService<T> {
	
	/**
	 * 查询数据。根据实体中的属性值进行查询，查询条件使用等号
	 * @author wuqingzhou
	 * 2017年2月22日下午5:27:32
	 */
	public List<T> select(T record);
	
	/**
	 * 查询数据。根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
	 * @author wuqingzhou
	 * 2017年2月22日下午5:28:12
	 */
	public T selectByPrimaryKey(Object key);
	
	/**
	 * 查询一条数据。根据实体中的属性进行查询，只能有一个返回值，有多个结果时抛出异常，查询条件使用等号
	 * @author wuqingzhou
	 * 2017年2月22日下午5:30:49
	 */
	public T selectOne(T record);
	
	/**
	 * 查询所有数据。查询全部结果，select(null)方法能达到同样的效果
	 * @author wuqingzhou
	 * 2017年2月22日下午5:30:03
	 */
	public List<T> selectAll();
	
	/**
	 * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
	 * 注：通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常
	 * @author wuqingzhou
	 * 2017年2月23日下午3:49:04
	 */
	public List<T> selectByIds(String ids);
	
	/**
	 * 查询记录数目。根据实体中的属性查询总数，查询条件使用等号
	 * @author wuqingzhou
	 * 2017年2月22日下午5:33:48
	 */
	public int selectCount(T record);
	
	/**
	 * 插入数据。保存一个实体，null的属性也会保存，不会使用数据库默认值
	 * @author wuqingzhou
	 * 2017年2月22日下午5:23:22
	 */
	public int insert(T record);
	
	/**
	 * 插入数据。保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @author wuqingzhou
	 * 2017年2月22日下午5:24:01
	 */
	public int insertSelective(T record);
	
	/**
	 * 批量插入。支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列。null的属性也会保存，不会使用数据库默认值
	 * @author wuqingzhou
	 * 2017年2月23日上午10:31:04
	 */
	int insertList(List<T> recordList);
	
	/**
	 * 删除数据。根据实体属性作为条件进行删除，查询条件使用等号
	 * @author wuqingzhou
	 * 2017年2月22日下午5:24:17
	 */
	public int delete(T record);
	
	/**
	 * 删除数据。根据主键字段进行删除，方法参数必须包含完整的主键属性
	 * @author wuqingzhou
	 * 2017年2月22日下午5:24:34
	 */
	public int deleteByPrimaryKey(Object key);
	
	/**
	 * 批量删除数据。根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
	 * @author wuqingzhou
	 * 2017年2月23日下午4:04:27
	 */
	public int deleteByIds(String ids);
	
	/**
	 * 更新数据。根据主键更新实体全部字段，null值会被更新
	 * @author wuqingzhou
	 * 2017年2月22日下午5:25:01
	 */
	public int updateByPrimaryKey(T record);
	
	/**
	 * 更新数据。根据主键更新属性不为null的值
	 * @author wuqingzhou
	 * 2017年2月22日下午5:25:25
	 */
	public int updateByPrimaryKeySelective(T record);
	
	public List<T> selectByCondition(Object condition);
	
	public int selectCountByCondition(Object condition);
	
	public int updateByCondition(@Param("record") T record, @Param("example") Object condition);
	
	public int updateByConditionSelective(@Param("record") T record, @Param("example") Object condition);
	
	public int deleteByCondition(Object condition);
	
	public List<T> selectByRowBounds(T record, RowBounds rowBounds);
	
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
}
