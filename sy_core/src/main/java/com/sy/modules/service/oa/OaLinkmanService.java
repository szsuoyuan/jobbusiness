package com.sy.modules.service.oa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.oa.OaLinkmanMapper;
import com.sy.modules.entity.oa.OaLinkman;
import com.sy.modules.entity.vo.oa.OaLinkmanVo;

@Service
public class OaLinkmanService {

	@Autowired
	private OaLinkmanMapper linkmanmapper;

	// find all linkmans by page
	public PageInfo<OaLinkman> findAllLinkMansByPage(OaLinkmanVo linkmanVo) {
		List<OaLinkman> list = new ArrayList<OaLinkman>(0);
		if (null != linkmanVo) {
			list = linkmanmapper.selectByExample(linkmanVo.toExample());
		}
		return new PageInfo<OaLinkman>(list);
	}

	// add linkman
	public int saveLinkman(OaLinkman linkman) {
		linkman.setDelStatus(Constants.ISDELSTATE.byteValue());
		linkman.setCreateTime(new Date());
		linkman.setUpdateTime(new Date());
		int num = linkmanmapper.insertSelective(linkman);
		return num;
	}

	// delete linkman
	public int deleteLinkman(OaLinkman linkman) {
		linkman.setDelStatus(Constants.DELSTATE.byteValue());
		return linkmanmapper.updateByPrimaryKeySelective(linkman);
	}

	// find linkman by id
	public OaLinkman findLinkman(Integer cId) {
		return linkmanmapper.selectByPrimaryKey(cId.longValue());
	}

	// update linkman
	public int updateLinkman(OaLinkman linkman) {
		linkman.setUpdateTime(new Date());
		int num = linkmanmapper.updateByPrimaryKeySelective(linkman);
		return num;
	}

}
