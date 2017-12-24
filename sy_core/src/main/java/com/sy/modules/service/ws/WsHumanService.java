package com.sy.modules.service.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.ws.WsHumanMapper;
import com.sy.modules.entity.vo.ws.WsHumanVo;
import com.sy.modules.entity.ws.WsHuman;

@Component
public class WsHumanService {
	
	@Autowired
	private WsHumanMapper humanmapper;
	
	//分页查询会员
	public PageInfo<WsHuman> findAllHumansByPage(WsHumanVo humanVo) {
		List<WsHuman> list = new ArrayList<WsHuman>(0);
		if (null != humanVo) {
			list = humanmapper.selectByExample(humanVo.toExample());
		}
		return new PageInfo<WsHuman>(list);
	}

	//添加会员
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addHuman(WsHuman wn){
		boolean success = false;
		wn.setCreateTime(new Date());
		humanmapper.insertSelective(wn);
		success = true;
		return success;
	}
	
	//根据会员账号查询会员信息
	public WsHuman findByAccount(String account)
	{
		return humanmapper.selectByHumanAccount(account);
	}
	//删除会员
	public int deleteHuman(WsHuman human) {
		human.setDelStatue(Constants.DELSTATE.byteValue());
		return humanmapper.updateByPrimaryKeySelective(human);
	}
	
	// find human by id
	public WsHuman findHuman(Integer hId) {
		return humanmapper.selectByPrimaryKey(hId.longValue());
	}
	
	// update human
	public int updateHuman(WsHuman human) {
		human.setUpdateTime(new Date());
		int num = humanmapper.updateByPrimaryKeySelective(human);
		return num;
	}
		
	//会员登录
	/*public WsHuman login(Long id,String username,String password)
	{
		return humanDao.login(id,username, password);
	}*/
}
