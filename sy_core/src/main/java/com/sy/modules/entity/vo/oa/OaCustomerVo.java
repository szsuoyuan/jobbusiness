package com.sy.modules.entity.vo.oa;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.oa.OaCustomerExample;
import com.sy.modules.entity.oa.OaCustomerExample.Criteria;
import com.sy.modules.entity.vo.BaseSearchObject;

public class OaCustomerVo extends BaseSearchObject<OaCustomerExample> {
	
	private String cName;//客户名称
	private Integer sysUserId;//客户所属人
	private Integer seaStatus;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Integer getSeaStatus() {
		return seaStatus;
	}

	public void setSeaStatus(Integer seaStatus) {
		this.seaStatus = seaStatus;
	}

	@Override
	public OaCustomerExample toExample() {
		OaCustomerExample filter = new OaCustomerExample();
		Criteria criteria = filter.createCriteria();
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE.byteValue());
		if (this.getcName() != null) {
			criteria.andCNameLike("%" + this.getcName() + "%");
		}
		if (this.getSeaStatus() != null) {
			criteria.andSeaStatusEqualTo(this.getSeaStatus().byteValue());
		}
		if(this.getSysUserId()!=null){
			criteria.andSysUserIdEqualTo(this.getSysUserId().longValue());
		}
		return filter;
	}

}
