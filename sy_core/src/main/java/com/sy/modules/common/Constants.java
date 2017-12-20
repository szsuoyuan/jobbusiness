package com.sy.modules.common;

/**
 * 常量类
 * 
 * @author sss 2013-8-15
 */
public abstract class Constants {
	
	//系统中表示假删除
	public static final Integer DELSTATE=0;	//删除
	
	public static final Integer ISDELSTATE=1; //可用
	
	//客户状态
	public enum CustomerStatus{
		QIANZAI(1),YIXIANG(2),QIATAN(3),CHENGJIAO(4),LIUSHI(5);
		private Integer number;
		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		private CustomerStatus(Integer number) {
			this.number = number;
		}
	}

}
