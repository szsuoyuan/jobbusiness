package com.sy.modules.service.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sy.modules.dao.sys.SysMenuMapper;
import com.sy.modules.entity.sys.SysMenu;
import com.sy.modules.entity.vo.SysMenuVo;

@Service
public class SysMenuService {
	
	@Autowired
	private SysMenuMapper menumapper;
	
	
	
	
	public List<SysMenu> findAllSysMenus(){
		return menumapper.findAllMenus();
	}
	
	
	public PageInfo<SysMenu> findAllSysMenusByPage(SysMenuVo sysMenuVo) {
		List<SysMenu> list = new ArrayList<SysMenu>(0);
		if (null != sysMenuVo) {
			list = menumapper.selectByExampleByPage(sysMenuVo.toExample());
		}
		return 	new PageInfo<SysMenu>(list);
	}

}
