package com.sy.modules.entity.sys;

import com.sy.commons.entity.ParentEntity;

public class SysComPicture extends ParentEntity {

	private static final long serialVersionUID = -1854369694827938935L;

	private String picname;
	private String picurl;
	private Long companyinfoid;

	public Long getCompanyinfoid() {
		return companyinfoid;
	}

	public void setCompanyinfoid(Long companyinfoid) {
		this.companyinfoid = companyinfoid;
	}

	public SysComPicture() {
	}

	public SysComPicture(String picname, String picurl) {
		this.picname = picname;
		this.picurl = picurl;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

}
