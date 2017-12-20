package com.sy.modules.service.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.ws.WsRecordMapper;
import com.sy.modules.entity.vo.ws.WsRecordVo;
import com.sy.modules.entity.ws.WsRecord;

@Service
public class WsRecordService {
	
	@Autowired
	private WsRecordMapper recordmapper;
	
	//分页查询所有打卡记录
	public PageInfo<WsRecord> findAllWsRecordByPage(WsRecordVo  recordVo) {
		List<WsRecord> list = new ArrayList<WsRecord>(0);
		if (null != recordVo) {
			recordVo.setDelStatus(Constants.ISDELSTATE);
			list = recordmapper.selectByExample(recordVo.toExample());
		}
		return new PageInfo<WsRecord>(list);
	}
	//创建打卡
	
	//删除打卡
	
	//修改打卡
	
	

}
