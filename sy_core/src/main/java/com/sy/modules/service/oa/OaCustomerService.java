package com.sy.modules.service.oa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.oa.OaCustomerMapper;
import com.sy.modules.entity.oa.OaCustomer;
import com.sy.modules.entity.vo.oa.OaCustomerVo;

@Service
public class OaCustomerService {

	@Autowired
	private OaCustomerMapper customermapper;

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
		return num;
	}
	
	//receive from sea
		public int receiveCustomer(OaCustomer custom){
			custom.setSeaStatus(Constants.ISDELSTATE.byteValue());
			return customermapper.updateByPrimaryKeySelective(custom);
		}

}
