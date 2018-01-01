package com.sy.modules.entity.ws;
import com.sy.commons.entity.ParentEntity;
/**
 * 图片
 * @author sss
 */
public class WsMtPicture extends ParentEntity {

	private static final long serialVersionUID = -3765377255350747067L;
	
	private Integer cId;//公司id
	private String pictureName; //图片名称
	private String pictureUrl;  //图片路径
	private String pictureType; //图片类型
	private String delStatus;   //删除标识

	public WsMtPicture() {
	}

	public WsMtPicture(String pictureName, String pictureUrl,
			String pictureType, String delStatus) {
		super();
		this.pictureName = pictureName;
		this.pictureUrl = pictureUrl;
		this.pictureType = pictureType;
		this.delStatus = delStatus;
	}


	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

}
