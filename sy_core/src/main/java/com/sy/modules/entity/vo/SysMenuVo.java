package com.sy.modules.entity.vo;

import java.util.ArrayList;
import java.util.List;

import com.sy.modules.entity.sys.SysMenuExample;
import com.sy.modules.entity.sys.SysMenuExample.Criteria;

public class SysMenuVo extends BaseSearchObject<SysMenuExample> {
	
	private List<Integer> menuList=new ArrayList<>();
	private String smName;

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public List<Integer> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Integer> menuList) {
		this.menuList = menuList;
	}

	@Override
	public SysMenuExample toExample() {
		SysMenuExample filter = new SysMenuExample();
		Criteria criteria = filter.createCriteria();
		//PageHelper.startPage(this.getPageNum(), this.getNumPerPage());
		if (this.getSmName() != null) {
			criteria.andSmNameLike("%"+this.getSmName()+"%");
		}
		if(null!=this.getMenuList()){
			criteria.andSmIdIn(this.getMenuList());
		}
		return filter;
	}
}
