package com.sy.modules.entity.vo;

public class SysUserVo {
	
	private String username;
	private String userpass;
	private String userremark;
	private Integer parentid;
	private Integer delstate;
	
	public  SysUserVo(){}

	public SysUserVo(String username, String userpass, String userremark,
			Integer parentid, Integer delstate) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.userremark = userremark;
		this.parentid = parentid;
		this.delstate = delstate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserremark() {
		return userremark;
	}

	public void setUserremark(String userremark) {
		this.userremark = userremark;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getDelstate() {
		return delstate;
	}

	public void setDelstate(Integer delstate) {
		this.delstate = delstate;
	}
	

}
