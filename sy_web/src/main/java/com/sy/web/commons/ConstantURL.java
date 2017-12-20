package com.sy.web.commons;

/**
 *维护常规操作后的forwardUrl
 *@author sss 2013-9-9
 */
public class ConstantURL {
	
	//-------------------------------------sss---------------------------------
	public static final String BGPICFORWARDURL="ws/findAllUsersByPage";
	
	public static final String SELFMODULEFORWARDURL="ws/getUserAndSelfModuleById";
	
	public static final String PARENTFORWARDURL="wx/findParentMenus";
	
	//-------------------------------------------------------------------------
	
	//服务器上使用(项目发布时改成微信服务器IP)
	//public static final String SERVER_PREFIX ="http://101.201.238.5/sy_web/";
	public static final String SERVER_PREFIX = "http://localhost:8080/sy_web/";

}
