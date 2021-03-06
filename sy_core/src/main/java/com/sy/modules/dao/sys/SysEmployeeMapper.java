package com.sy.modules.dao.sys;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.sys.SysEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@MyBatisRepository
public interface SysEmployeeMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int countByExample(SysEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(SysEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer eId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int insert(SysEmployee record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int insertSelective(SysEmployee record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	List<SysEmployee> selectByExampleWithRowbounds(SysEmployeeExample example,
			RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	List<SysEmployee> selectByExample(SysEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	SysEmployee selectByPrimaryKey(Integer eId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") SysEmployee record,
			@Param("example") SysEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") SysEmployee record,
			@Param("example") SysEmployeeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(SysEmployee record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sys_employee
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(SysEmployee record);
}