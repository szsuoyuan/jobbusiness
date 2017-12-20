package com.sy.modules.entity.oa;

import java.io.Serializable;
import java.util.Date;

public class OaLinkman implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_id
     *
     * @mbggenerated
     */
    private Long lmId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_name
     *
     * @mbggenerated
     */
    private String lmName;//联系人姓名

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.c_id
     *
     * @mbggenerated
     */
    private Long cId;
    
    private String cCustomer;

    public String getcCustomer() {
		return cCustomer;
	}

	public void setcCustomer(String cCustomer) {
		this.cCustomer = cCustomer;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.sys_user_id
     *
     * @mbggenerated
     */
    private Integer sysUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_post
     *
     * @mbggenerated
     */
    private String lmPost;//职务

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_email
     *
     * @mbggenerated
     */
    private String lmEmail;//邮箱

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_qq
     *
     * @mbggenerated
     */
    private String lmQq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_wechat
     *
     * @mbggenerated
     */
    private String lmWechat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_mobile
     *
     * @mbggenerated
     */
    private String lmMobile;//联系人电话

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone1
     *
     * @mbggenerated
     */
    private String lmPhone1;//新郎电话

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone2
     *
     * @mbggenerated
     */
    private String lmPhone2;//新娘电话

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone3
     *
     * @mbggenerated
     */
    private String lmPhone3;//委托人电话

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone4
     *
     * @mbggenerated
     */
    private String lmPhone4;//家长电话

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone5
     *
     * @mbggenerated
     */
    private String lmPhone5;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_phone6
     *
     * @mbggenerated
     */
    private String lmPhone6;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.lm_birth
     *
     * @mbggenerated
     */
    private String lmBirth;//生日

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.del_status
     *
     * @mbggenerated
     */
    private Byte delStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.create_name
     *
     * @mbggenerated
     */
    private String createName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.update_name
     *
     * @mbggenerated
     */
    private String updateName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oa_linkman.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oa_linkman
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_id
     *
     * @return the value of oa_linkman.lm_id
     *
     * @mbggenerated
     */
    public Long getLmId() {
        return lmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_id
     *
     * @param lmId the value for oa_linkman.lm_id
     *
     * @mbggenerated
     */
    public void setLmId(Long lmId) {
        this.lmId = lmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_name
     *
     * @return the value of oa_linkman.lm_name
     *
     * @mbggenerated
     */
    public String getLmName() {
        return lmName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_name
     *
     * @param lmName the value for oa_linkman.lm_name
     *
     * @mbggenerated
     */
    public void setLmName(String lmName) {
        this.lmName = lmName == null ? null : lmName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.c_id
     *
     * @return the value of oa_linkman.c_id
     *
     * @mbggenerated
     */
    public Long getcId() {
        return cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.c_id
     *
     * @param cId the value for oa_linkman.c_id
     *
     * @mbggenerated
     */
    public void setcId(Long cId) {
        this.cId = cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.sys_user_id
     *
     * @return the value of oa_linkman.sys_user_id
     *
     * @mbggenerated
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.sys_user_id
     *
     * @param sysUserId the value for oa_linkman.sys_user_id
     *
     * @mbggenerated
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_post
     *
     * @return the value of oa_linkman.lm_post
     *
     * @mbggenerated
     */
    public String getLmPost() {
        return lmPost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_post
     *
     * @param lmPost the value for oa_linkman.lm_post
     *
     * @mbggenerated
     */
    public void setLmPost(String lmPost) {
        this.lmPost = lmPost == null ? null : lmPost.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_email
     *
     * @return the value of oa_linkman.lm_email
     *
     * @mbggenerated
     */
    public String getLmEmail() {
        return lmEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_email
     *
     * @param lmEmail the value for oa_linkman.lm_email
     *
     * @mbggenerated
     */
    public void setLmEmail(String lmEmail) {
        this.lmEmail = lmEmail == null ? null : lmEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_qq
     *
     * @return the value of oa_linkman.lm_qq
     *
     * @mbggenerated
     */
    public String getLmQq() {
        return lmQq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_qq
     *
     * @param lmQq the value for oa_linkman.lm_qq
     *
     * @mbggenerated
     */
    public void setLmQq(String lmQq) {
        this.lmQq = lmQq == null ? null : lmQq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_wechat
     *
     * @return the value of oa_linkman.lm_wechat
     *
     * @mbggenerated
     */
    public String getLmWechat() {
        return lmWechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_wechat
     *
     * @param lmWechat the value for oa_linkman.lm_wechat
     *
     * @mbggenerated
     */
    public void setLmWechat(String lmWechat) {
        this.lmWechat = lmWechat == null ? null : lmWechat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_mobile
     *
     * @return the value of oa_linkman.lm_mobile
     *
     * @mbggenerated
     */
    public String getLmMobile() {
        return lmMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_mobile
     *
     * @param lmMobile the value for oa_linkman.lm_mobile
     *
     * @mbggenerated
     */
    public void setLmMobile(String lmMobile) {
        this.lmMobile = lmMobile == null ? null : lmMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone1
     *
     * @return the value of oa_linkman.lm_phone1
     *
     * @mbggenerated
     */
    public String getLmPhone1() {
        return lmPhone1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone1
     *
     * @param lmPhone1 the value for oa_linkman.lm_phone1
     *
     * @mbggenerated
     */
    public void setLmPhone1(String lmPhone1) {
        this.lmPhone1 = lmPhone1 == null ? null : lmPhone1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone2
     *
     * @return the value of oa_linkman.lm_phone2
     *
     * @mbggenerated
     */
    public String getLmPhone2() {
        return lmPhone2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone2
     *
     * @param lmPhone2 the value for oa_linkman.lm_phone2
     *
     * @mbggenerated
     */
    public void setLmPhone2(String lmPhone2) {
        this.lmPhone2 = lmPhone2 == null ? null : lmPhone2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone3
     *
     * @return the value of oa_linkman.lm_phone3
     *
     * @mbggenerated
     */
    public String getLmPhone3() {
        return lmPhone3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone3
     *
     * @param lmPhone3 the value for oa_linkman.lm_phone3
     *
     * @mbggenerated
     */
    public void setLmPhone3(String lmPhone3) {
        this.lmPhone3 = lmPhone3 == null ? null : lmPhone3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone4
     *
     * @return the value of oa_linkman.lm_phone4
     *
     * @mbggenerated
     */
    public String getLmPhone4() {
        return lmPhone4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone4
     *
     * @param lmPhone4 the value for oa_linkman.lm_phone4
     *
     * @mbggenerated
     */
    public void setLmPhone4(String lmPhone4) {
        this.lmPhone4 = lmPhone4 == null ? null : lmPhone4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone5
     *
     * @return the value of oa_linkman.lm_phone5
     *
     * @mbggenerated
     */
    public String getLmPhone5() {
        return lmPhone5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone5
     *
     * @param lmPhone5 the value for oa_linkman.lm_phone5
     *
     * @mbggenerated
     */
    public void setLmPhone5(String lmPhone5) {
        this.lmPhone5 = lmPhone5 == null ? null : lmPhone5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_phone6
     *
     * @return the value of oa_linkman.lm_phone6
     *
     * @mbggenerated
     */
    public String getLmPhone6() {
        return lmPhone6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_phone6
     *
     * @param lmPhone6 the value for oa_linkman.lm_phone6
     *
     * @mbggenerated
     */
    public void setLmPhone6(String lmPhone6) {
        this.lmPhone6 = lmPhone6 == null ? null : lmPhone6.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.lm_birth
     *
     * @return the value of oa_linkman.lm_birth
     *
     * @mbggenerated
     */
    public String getLmBirth() {
        return lmBirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.lm_birth
     *
     * @param lmBirth the value for oa_linkman.lm_birth
     *
     * @mbggenerated
     */
    public void setLmBirth(String lmBirth) {
        this.lmBirth = lmBirth == null ? null : lmBirth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.del_status
     *
     * @return the value of oa_linkman.del_status
     *
     * @mbggenerated
     */
    public Byte getDelStatus() {
        return delStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.del_status
     *
     * @param delStatus the value for oa_linkman.del_status
     *
     * @mbggenerated
     */
    public void setDelStatus(Byte delStatus) {
        this.delStatus = delStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.create_name
     *
     * @return the value of oa_linkman.create_name
     *
     * @mbggenerated
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.create_name
     *
     * @param createName the value for oa_linkman.create_name
     *
     * @mbggenerated
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.create_time
     *
     * @return the value of oa_linkman.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.create_time
     *
     * @param createTime the value for oa_linkman.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.update_name
     *
     * @return the value of oa_linkman.update_name
     *
     * @mbggenerated
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.update_name
     *
     * @param updateName the value for oa_linkman.update_name
     *
     * @mbggenerated
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oa_linkman.update_time
     *
     * @return the value of oa_linkman.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oa_linkman.update_time
     *
     * @param updateTime the value for oa_linkman.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}