package com.sy.modules.service.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.sys.SysEmployeeMapper;
import com.sy.modules.dao.sys.UserDao;
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.vo.SysEmployeeVo;

@Service
@Transactional
public class SysEmployeeService {

	@Autowired
	private SysEmployeeMapper employmapper;
	@Autowired
	private UserDao userDao;

	// 查询所有员工
	public PageInfo<SysEmployee> findAllSysEmployeesByPage(SysEmployeeVo employeeVo) {
		List<SysEmployee> list = new ArrayList<SysEmployee>(0);
		if (null != employeeVo) {
			employeeVo.seteState(Constants.ISDELSTATE);
			list = employmapper.selectByExample(employeeVo.toExample());
		}
		return new PageInfo<SysEmployee>(list);
	}
	
	//添加员工
	public int saveEmployee(SysEmployee emp){
		emp.setDelStatus(Constants.ISDELSTATE);
		//将这个帐号标记为已用
		if(null !=emp.getSysUserId() && emp.getSysUserId()>0){
			userDao.updateUserWithUse((emp.getSysUserId()).longValue());
		}
		int num=employmapper.insertSelective(emp);
		return num;
	}
	
	//删除
	public int deleteEmployee(SysEmployee emp){
		emp.setDelStatus(Constants.DELSTATE);
		return employmapper.updateByPrimaryKeySelective(emp);
	}
	
	public SysEmployee findEmplyee(Integer empId){
		return employmapper.selectByPrimaryKey(empId);
	}
	//修改
	public int updateEmployee(SysEmployee emp){
		if(null !=emp.getSysUserId() && emp.getSysUserId()>0){
			userDao.updateUserWithUse((emp.getSysUserId()).longValue());
		}
		emp.setUpdateTime(new Date());
		int num=employmapper.updateByPrimaryKeySelective(emp);
		return num;
	}

}
