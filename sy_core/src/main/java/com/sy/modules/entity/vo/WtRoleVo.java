package com.sy.modules.entity.vo;


import com.github.pagehelper.PageHelper;
import com.sy.modules.entity.sys.WtRoleExample;
import com.sy.modules.entity.sys.WtRoleExample.Criteria;

public class WtRoleVo extends BaseSearchObject<WtRoleExample> {
	
	private String wtRName;
	private Integer sysUserId;//所属公司id
	private Integer delState;

	public String getWtRName() {
		return wtRName;
	}

	public void setWtRName(String wtRName) {
		this.wtRName = wtRName;
	}

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Integer getDelState() {
		return delState;
	}

	public void setDelState(Integer delState) {
		this.delState = delState;
	}

	@Override
	public WtRoleExample toExample() {
		WtRoleExample filter = new WtRoleExample();
		Criteria criteria = filter.createCriteria();
		
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		//criteria.andNewsStatusEqualTo(RecordState.normal.getByteIndex());
		if (this.getWtRName() != null) {
			criteria.andWtRNameLike("%"+this.getWtRName()+"%");
		}
		if(this.getSysUserId()!=null){
			criteria.andSysUserIdEqualTo(this.getSysUserId());
		}
		if(this.getDelState() !=null){
			criteria.andDelStateEqualTo(this.getDelState());
			
		}
		return filter;
	}

	
}
