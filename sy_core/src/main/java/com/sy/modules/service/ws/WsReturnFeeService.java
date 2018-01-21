package com.sy.modules.service.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.ws.WsFanFeiMapper;
import com.sy.modules.entity.vo.ws.WsFanFeiVo;
import com.sy.modules.entity.ws.WsFanFei;

@Service
@Transactional
public class WsReturnFeeService {
	
	@Autowired
	private WsFanFeiMapper fanfeimapper;
	
	// find all fee by page
	public PageInfo<WsFanFei> findAllFanFeiByPage(WsFanFeiVo fanfeiVo) {
		List<WsFanFei> list = new ArrayList<WsFanFei>(0);
		if (null != fanfeiVo) {
			list = fanfeimapper.selectByExample(fanfeiVo.toExample());
		}
		return new PageInfo<WsFanFei>(list);
	}
	
	// add fanfei
	public int saveFanFei(WsFanFei fanfei) {
		fanfei.setDelStatus(Constants.ISDELSTATE.byteValue());
		fanfei.setCreateTime(new Date());
		fanfei.setUpdateTime(new Date());
		int num = fanfeimapper.insertSelective(fanfei);
		return num;
	}

	// delete record
	public int deleteFanFei(WsFanFei fanfei) {
		fanfei.setDelStatus(Constants.DELSTATE.byteValue());
		return fanfeimapper.updateByPrimaryKeySelective(fanfei);
	}
	
	// find fanfei by id
	public WsFanFei findFanFei(Integer fId) {
		return fanfeimapper.selectByPrimaryKey(fId);
	}

	// update fanfei
	public int updateFanFei(WsFanFei fanfei) {
		fanfei.setUpdateTime(new Date());
		int num = fanfeimapper.updateByPrimaryKeySelective(fanfei);
		return num;
	}
		
}
