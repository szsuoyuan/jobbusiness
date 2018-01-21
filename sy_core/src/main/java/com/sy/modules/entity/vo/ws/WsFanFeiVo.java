package com.sy.modules.entity.vo.ws;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.vo.BaseSearchObject;
import com.sy.modules.entity.ws.WsFanFeiExample;
import com.sy.modules.entity.ws.WsFanFeiExample.Criteria;

public class WsFanFeiVo extends BaseSearchObject<WsFanFeiExample> {
	
	 private String fName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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
		return filter;
	}
	
}
