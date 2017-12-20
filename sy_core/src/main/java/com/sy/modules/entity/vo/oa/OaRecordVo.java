package com.sy.modules.entity.vo.oa;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.oa.OaRecordExample;
import com.sy.modules.entity.oa.OaRecordExample.Criteria;
import com.sy.modules.entity.vo.BaseSearchObject;

public class OaRecordVo extends BaseSearchObject<OaRecordExample> {
	private Byte rMode;//跟进方式
	private Long cId;//客户id

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Byte getrMode() {
		return rMode;
	}

	public void setrMode(Byte rMode) {
		this.rMode = rMode;
	}

	@Override
	public OaRecordExample toExample() {
		OaRecordExample filter = new OaRecordExample();
		Criteria criteria = filter.createCriteria();
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE.byteValue());
		if (this.getcId() != null) {
			criteria.andCIdEqualTo(this.getcId());
		}
		if(this.getrMode()!=null){
			criteria.andRModeEqualTo(this.getrMode());
		}
		return filter;
	}

}
