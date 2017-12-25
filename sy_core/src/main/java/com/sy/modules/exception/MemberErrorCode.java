package com.sy.modules.exception;

import java.text.MessageFormat;


/**
 * Created by Howard.Miao on 2015/6/12.
 */
public enum MemberErrorCode implements ErrorCode {
	 LOGIN_ERROR_PWD_INCORRECT("LOGIN_ERROR_PWD_INCORRECT", "密码错误"),
	    LOGIN_ERROR_ACCOUNT_INACTIVATION("LOGIN_ERROR_ACCOUNT_INACTIVATION", "未激活账户"),
	    LOGIN_ERROR_ACCOUNT_NOT_EXIST("LOGIN_ERROR_ACCOUNT_NOT_EXIST", "账户不存在");

	    private String _code;
	    private String _desc;

	    MemberErrorCode(String code, String desc) {
	        this._code = code;
	        this._desc = desc;
	    }

	    @Override
	    public String getCode() {
	        return null;
	    }

	    @Override
	    public String getDesc() {
	        return null;
	    }

	    @Override
	    public String parse(Object... args) {
	        return MessageFormat.format(_desc, args);
	    }
	    
	   /* public static void main(String[] args){
	    	System.out.println(new ApplicationException(MemberErrorCode.LOGIN_ERROR_PWD_INCORRECT));
	    }*/
  
}
