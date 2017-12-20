package com.sy.modules.entity.vo.oa;

import com.github.pagehelper.PageHelper;
import com.sy.modules.common.Constants;
import com.sy.modules.entity.oa.OaLinkmanExample;
import com.sy.modules.entity.oa.OaLinkmanExample.Criteria;
import com.sy.modules.entity.vo.BaseSearchObject;

public class OaLinkmanVo extends BaseSearchObject<OaLinkmanExample> {

	private String lmName;
	private String lmMobile;
	private Long cId;

	public String getLmName() {
		return lmName;
	}

	public void setLmName(String lmName) {
		this.lmName = lmName;
	}

	public String getLmMobile() {
		return lmMobile;
	}

	public void setLmMobile(String lmMobile) {
		this.lmMobile = lmMobile;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	@Override
	public OaLinkmanExample toExample() {
		OaLinkmanExample filter = new OaLinkmanExample();
		Criteria criteria = filter.createCriteria();
		PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		criteria.andDelStatusEqualTo(Constants.ISDELSTATE.byteValue());
		if (this.getLmName() != null) {
			criteria.andLmNameLike("%" + this.getLmName() + "%");
		}
		if (this.getLmMobile() != null) {
			criteria.andLmMobileLike("%" + this.getLmMobile() + "%");
		}
		if (this.getcId() != null) {
			criteria.andCIdEqualTo(this.getcId());
		}
		return filter;
	}
}
