package com.sy.modules.entity.ws;

import com.sy.commons.entity.ParentEntity;

/**
 * 商家管理
 * 
 * @author LHL
 */
public class WsHuman extends ParentEntity {
	private static final long serialVersionUID = 1L;
	private String human_account; // 账号
	private String human_password; // 密码
	private String human_question; // 昵称
	private String human_sex;//性别
	private String human_answer;//出生年月
	private String human_phone; // 手机号
	private String human_qq;
	private String human_name; //真实姓名
	private String human_address; // 家乡
	private String human_remark;//个性签名
	private String human_pic_url;//头像
	private String human_status;//求职状态
	private String human_education;//学历
	private String human_address_curr;//现在居住地
	private String human_address_hope;//期望居住地
	private String del_status;//软删状态
	
	private WsHumanUser wsHumanUser;

	public String getHuman_account() {
		return human_account;
	}

	public void setHuman_account(String human_account) {
		this.human_account = human_account;
	}

	public String getHuman_password() {
		return human_password;
	}

	public void setHuman_password(String human_password) {
		this.human_password = human_password;
	}

	public String getHuman_question() {
		return human_question;
	}

	public void setHuman_question(String human_question) {
		this.human_question = human_question;
	}

	public String getHuman_answer() {
		return human_answer;
	}

	public void setHuman_answer(String human_answer) {
		this.human_answer = human_answer;
	}

	public String getHuman_phone() {
		return human_phone;
	}

	public void setHuman_phone(String human_phone) {
		this.human_phone = human_phone;
	}

	public String getHuman_qq() {
		return human_qq;
	}

	public void setHuman_qq(String human_qq) {
		this.human_qq = human_qq;
	}

	public String getHuman_name() {
		return human_name;
	}

	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}

	public String getHuman_address() {
		return human_address;
	}

	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}


	public String getHuman_sex() {
		return human_sex;
	}

	public void setHuman_sex(String human_sex) {
		this.human_sex = human_sex;
	}

	public String getHuman_remark() {
		return human_remark;
	}

	public void setHuman_remark(String human_remark) {
		this.human_remark = human_remark;
	}

	public String getHuman_pic_url() {
		return human_pic_url;
	}

	public void setHuman_pic_url(String human_pic_url) {
		this.human_pic_url = human_pic_url;
	}

	public String getHuman_status() {
		return human_status;
	}

	public void setHuman_status(String human_status) {
		this.human_status = human_status;
	}

	public String getHuman_education() {
		return human_education;
	}

	public void setHuman_education(String human_education) {
		this.human_education = human_education;
	}

	public String getHuman_address_curr() {
		return human_address_curr;
	}

	public void setHuman_address_curr(String human_address_curr) {
		this.human_address_curr = human_address_curr;
	}

	public String getHuman_address_hope() {
		return human_address_hope;
	}

	public void setHuman_address_hope(String human_address_hope) {
		this.human_address_hope = human_address_hope;
	}

	public String getDel_status() {
		return del_status;
	}

	public void setDel_status(String del_status) {
		this.del_status = del_status;
	}

	public WsHumanUser getWsHumanUser() {
		return wsHumanUser;
	}

	public void setWsHumanUser(WsHumanUser wsHumanUser) {
		this.wsHumanUser = wsHumanUser;
	}
	
	public String toString() {
		return "human name is："+this.getHuman_name();
	}
}
