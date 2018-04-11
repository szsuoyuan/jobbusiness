package com.sy.modules.service.oa;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sy.modules.common.AbstractService;
import com.sy.modules.dao.oa.OaCustomerHisPriceDao;
import com.sy.modules.entity.oa.OaCustomerHisPrice;

@Component
public class OaCustomerHisPriceService extends AbstractService<OaCustomerHisPrice, Integer, OaCustomerHisPriceDao> {

	@Autowired
	private OaCustomerHisPriceDao hisPriceDao;

	@Override
	protected OaCustomerHisPriceDao getDao() {
		return hisPriceDao;
	}

	public void createHisPrice(OaCustomerHisPrice hisPrice) {
		hisPriceDao.create(hisPrice);

	}
	//search history price by paging
	public List<OaCustomerHisPrice> findAllHisPriceByPage(Map<String, Object> map){
		return hisPriceDao.findAllHisPriceByPage(map);
	}
	
}
