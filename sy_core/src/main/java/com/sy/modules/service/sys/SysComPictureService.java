package com.sy.modules.service.sys;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sy.modules.common.AbstractService;
import com.sy.modules.dao.sys.SysComPictureDao;
import com.sy.modules.entity.sys.SysComPicture;

@Component
public class SysComPictureService extends AbstractService<SysComPicture, Long, SysComPictureDao> {

	@Autowired
	private SysComPictureDao compicuredao;
	@Override
	protected SysComPictureDao getDao() {
		return compicuredao;
	}

	// 分页查询公司图片列表
	public List<SysComPicture> findAllComPicByPage(Map<String, Object> map) {
		return compicuredao.findAllComPicByPage(map);
	}

	// 图片总数
	public Long findCountByParam(Map<String, Object> map) {
		return compicuredao.findCountByParam(map);
	}
	
	   //查询所有轮播图
    public List<SysComPicture> findAllComPic(){
    	return compicuredao.findAllComPic();
    }
}
