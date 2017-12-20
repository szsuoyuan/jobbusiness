package com.sy.modules.entity.vo.ws;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.vo.BaseSearchObject;
import com.sy.modules.entity.ws.WsRecordExample;
import com.sy.modules.entity.ws.WsRecordExample.Criteria;

public class WsRecordVo extends BaseSearchObject<WsRecordExample> {
	
	private String emName;
	private String rDay;
	private Integer delStatus;

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getrDay() {
		return rDay;
	}

	public void setrDay(String rDay) {
		this.rDay = rDay;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public WsRecordExample toExample() {
		WsRecordExample filter=new WsRecordExample();
		Criteria criteria = filter.createCriteria();
		criteria.andRDelstatusEqualTo(Constants.ISDELSTATE);
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		if(this.getEmName()!=null){
			criteria.andEmNameLike("%" + this.getEmName() + "%");
		}
		return filter;
	}

}
