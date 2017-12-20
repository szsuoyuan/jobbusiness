package com.sy.modules.entity.vo;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.sys.SysEmployeeExample;
import com.sy.modules.entity.sys.SysEmployeeExample.Criteria;

public class SysEmployeeVo extends BaseSearchObject<SysEmployeeExample> {

	private String eName;
	private Integer sysUserId;
	private Integer eState;

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Integer geteState() {
		return eState;
	}

	public void seteState(Integer eState) {
		this.eState = eState;
	}

	@Override
	public SysEmployeeExample toExample() {
		SysEmployeeExample filter = new SysEmployeeExample();
		Criteria criteria = filter.createCriteria();
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE);
		if (this.geteName() != null) {
			criteria.andENameLike("%" + this.geteName() + "%");
		}
		return filter;
	}

}
