package com.sy.modules.service.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.ws.WsOrderMapper;
import com.sy.modules.entity.vo.ws.WsOrderVo;
import com.sy.modules.entity.ws.WsOrder;

@Component
public class WsOrderService {
	@Autowired
	private WsOrderMapper ordermapper;

	// 分页查询订单
	public PageInfo<WsOrder> findAllWsOrdersByPage(WsOrderVo orderVo) {
		List<WsOrder> list = new ArrayList<WsOrder>(0);
		if (null != orderVo) {
			list = ordermapper.selectByExample(orderVo.toExample());
		}
		return new PageInfo<WsOrder>(list);
	}

	// add order
	public int saveWsOrder(WsOrder order) {
		order.setDelStatus(Constants.ISDELSTATE.toString());
		order.setCreateTime(new Date());
		int num = ordermapper.insertSelective(order);
		return num;
	}

	// delete record
	public int deleteWsOrder(WsOrder order) {
		order.setDelStatus(Constants.DELSTATE.toString());
		return ordermapper.updateByPrimaryKeySelective(order);
	}

	// find order by id
	public WsOrder findWsOrder(Integer oId) {
		return ordermapper.selectByPrimaryKey(oId);
	}

	// update order
	public int updateWsOrder(WsOrder order) {
		int num = ordermapper.updateByPrimaryKeySelective(order);
		return num;
	}

}
