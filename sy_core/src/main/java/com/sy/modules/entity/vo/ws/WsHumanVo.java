package com.sy.modules.entity.vo.ws;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.vo.BaseSearchObject;
import com.sy.modules.entity.ws.WsHumanExample;
import com.sy.modules.entity.ws.WsHumanExample.Criteria;

public class WsHumanVo extends BaseSearchObject<WsHumanExample> {

	private String humanName;

	public String getHumanName() {
		return humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	@Override
	public WsHumanExample toExample() {
		WsHumanExample filter = new WsHumanExample();
		Criteria criteria = filter.createCriteria();
		criteria.andDelStatueEqualTo(Constants.ISDELSTATE.byteValue());
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		if (this.getHumanName() != null) {
			criteria.andHumanNameLike("%" + this.getHumanName() + "%");
		}
		return filter;
	}
}
