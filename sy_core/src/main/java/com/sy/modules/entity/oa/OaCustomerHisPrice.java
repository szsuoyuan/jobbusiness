package com.sy.modules.entity.oa;

import com.sy.commons.entity.ParentEntity;

public class OaCustomerHisPrice extends ParentEntity {
	private static final long serialVersionUID = 4453032734070126512L;

	private Integer pId;
	private Integer cId;
	private String pName;
	private String pRemark;

	public OaCustomerHisPrice() {
	}

	public OaCustomerHisPrice(Integer pId, Integer cId, String pName, String pRemark) {
		super();
		this.pId = pId;
		this.cId = cId;
		this.pName = pName;
		this.pRemark = pRemark;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

}
