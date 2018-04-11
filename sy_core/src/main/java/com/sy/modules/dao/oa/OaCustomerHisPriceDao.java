package com.sy.modules.dao.oa;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.common.ParentDao;
import com.sy.modules.entity.oa.OaCustomerHisPrice;

@Component
@MyBatisRepository
public interface OaCustomerHisPriceDao extends ParentDao<OaCustomerHisPrice, Integer> {
	
	List<OaCustomerHisPrice> findAllHisPriceByPage(Map<String, Object> map);

}
