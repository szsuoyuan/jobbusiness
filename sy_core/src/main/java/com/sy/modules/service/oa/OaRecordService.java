package com.sy.modules.service.oa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.oa.OaRecordMapper;
import com.sy.modules.entity.oa.OaRecord;
import com.sy.modules.entity.vo.oa.OaRecordVo;

@Service
public class OaRecordService {

	@Autowired
	private OaRecordMapper recordmapper;

	// find all records by page
	public PageInfo<OaRecord> findAllRecordsByPage(OaRecordVo recordVo) {
		List<OaRecord> list = new ArrayList<OaRecord>(0);
		if (null != recordVo) {
			list = recordmapper.selectByExample(recordVo.toExample());
		}
		return new PageInfo<OaRecord>(list);
	}

	// add record
	public int saveRecord(OaRecord record) {
		record.setDelStatus(Constants.ISDELSTATE.byteValue());
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		int num = recordmapper.insertSelective(record);
		return num;
	}

	// delete record
	public int deleteRecord(OaRecord record) {
		record.setDelStatus(Constants.DELSTATE.byteValue());
		return recordmapper.updateByPrimaryKeySelective(record);
	}

	// find record by id
	public OaRecord findRecord(Integer rId) {
		return recordmapper.selectByPrimaryKey(rId.longValue());
	}

	// update record
	public int updateRecord(OaRecord record) {
		record.setUpdateTime(new Date());
		int num = recordmapper.updateByPrimaryKeySelective(record);
		return num;
	}

}
