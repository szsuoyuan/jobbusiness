package com.sy.modules.entity.vo.ws;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.vo.BaseSearchObject;
import com.sy.modules.entity.ws.WsFanFeiExample;
import com.sy.modules.entity.ws.WsFanFeiExample.Criteria;

public class WsFanFeiVo extends BaseSearchObject<WsFanFeiExample> {
	
	 private String fName;
	 
	 private Integer fType;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public Integer getfType() {
		return fType;
	}

	public void setfType(Integer fType) {
		this.fType = fType;
	}

	@Override
	public WsFanFeiExample toExample() {
		WsFanFeiExample filter=new  WsFanFeiExample();
		Criteria criteria = filter.createCriteria();
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE.byteValue());
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		if(this.getfName()!=null){
			criteria.andFNameLike("%" + this.getfName() + "%");
		}
		if(this.getfType()!=null){
			criteria.andFTypeEqualTo(this.getfType().byteValue());
		}
		return filter;
	}
	
}
