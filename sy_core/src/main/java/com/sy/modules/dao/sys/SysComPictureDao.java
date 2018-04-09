package com.sy.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.sy.modules.common.MyBatisRepository;
import com.sy.modules.common.ParentDao;
import com.sy.modules.entity.sys.SysComPicture;

@Component
@MyBatisRepository
public interface SysComPictureDao extends ParentDao<SysComPicture, Long> {
	
	//分页查询公司图片列表
	public List<SysComPicture> findAllComPicByPage(Map<String,Object> map);
	
	//图片总数
    public Long findCountByParam(Map<String,Object> map);
    
    //查询所有轮播图
    public List<SysComPicture> findAllComPic();
}
