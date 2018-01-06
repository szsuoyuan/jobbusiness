package com.sy.modules.service.oa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.oa.OaCustomerMapper;
import com.sy.modules.dao.ws.WsPictureDao;
import com.sy.modules.entity.oa.OaCustomer;
import com.sy.modules.entity.vo.oa.OaCustomerVo;
import com.sy.modules.entity.ws.WsMtPicture;

@Service
@Transactional
public class OaCustomerService {

	@Autowired
	private OaCustomerMapper customermapper;
	
	@Autowired
	private WsPictureDao picturedao;

	// find all customers by page
	public PageInfo<OaCustomer> findAllCustomersByPage(OaCustomerVo customerVo) {
		List<OaCustomer> list = new ArrayList<OaCustomer>(0);
		if (null != customerVo) {
			customerVo.setSeaStatus(Constants.ISDELSTATE);
			list = customermapper.selectByExample(customerVo.toExample());
		}
		return new PageInfo<OaCustomer>(list);
	}
	// find all customers by page in sea
	public PageInfo<OaCustomer> findAllCustomersByPageInSea(OaCustomerVo customerVo) {
		List<OaCustomer> list = new ArrayList<OaCustomer>(0);
		if (null != customerVo) {
			customerVo.setSeaStatus(Constants.DELSTATE);//0在公海
			list = customermapper.selectByExample(customerVo.toExample());
		}
		return new PageInfo<OaCustomer>(list);
	}

	// add customer
	public int saveCustomer(OaCustomer custom) {
		custom.setDelStatus(Constants.ISDELSTATE.byteValue());
		custom.setCreateTime(new Date());
		custom.setUpdateTime(new Date());
		int num = customermapper.insertSelective(custom);
		//岗位图片
		if(null!=custom.getJobpictures()){
			for(WsMtPicture picture:custom.getJobpictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		//创建图片
		if(null!=custom.getPictures()){
			for(WsMtPicture picture:custom.getPictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		if(null!=custom.getHspictures()){
			for(WsMtPicture picture:custom.getHspictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		return num;
	}

	// delete customer
	public int deleteCustomer(OaCustomer custom) {
		custom.setDelStatus(Constants.DELSTATE.byteValue());
		return customermapper.updateByPrimaryKeySelective(custom);
	}

	//return sea
	public int returnSeaCustomer(OaCustomer custom){
		custom.setSeaStatus(Constants.DELSTATE.byteValue());
		return customermapper.updateByPrimaryKeySelective(custom);
	}
	// find customer by id
	public OaCustomer findCustomer(Integer cId) {
		return customermapper.selectByPrimaryKey(cId.longValue());
	}

	// update customer
	public int updateCustomer(OaCustomer custom) {
		custom.setUpdateTime(new Date());
		int num = customermapper.updateByPrimaryKeySelective(custom);
		if(null != custom.getJobpictures()){
			picturedao.deletePictureByCId(custom.getcId().intValue(),"job");
			for(WsMtPicture picture:custom.getJobpictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		if(null!=custom.getPictures()){
			picturedao.deletePictureByCId(custom.getcId().intValue(),"zs");
			for(WsMtPicture picture:custom.getPictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		if(null!=custom.getHspictures()){
			picturedao.deletePictureByCId(custom.getcId().intValue(),"hs");
			for(WsMtPicture picture:custom.getHspictures()){
				picture.setcId(custom.getcId().intValue());
				picturedao.create(picture);
			}
		}
		return num;
	}
	
	//receive from sea
		public int receiveCustomer(OaCustomer custom){
			custom.setSeaStatus(Constants.ISDELSTATE.byteValue());
			return customermapper.updateByPrimaryKeySelective(custom);
		}

}
