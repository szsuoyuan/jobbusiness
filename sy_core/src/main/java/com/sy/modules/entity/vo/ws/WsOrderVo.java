package com.sy.modules.entity.vo.ws;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.vo.BaseSearchObject;
import com.sy.modules.entity.ws.WsOrderExample;
import com.sy.modules.entity.ws.WsOrderExample.Criteria;

public class WsOrderVo extends BaseSearchObject<WsOrderExample> {
	private String oNumber;

	public String getoNumber() {
		return oNumber;
	}

	public void setoNumber(String oNumber) {
		this.oNumber = oNumber;
	}

	@Override
	public WsOrderExample toExample() {
		WsOrderExample filter=new WsOrderExample();
		Criteria criteria = filter.createCriteria();
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE.toString());
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		if(this.getoNumber()!=null){
			criteria.andONumberLike("%" + this.getoNumber() + "%");
		}
		return filter;
	}
}
