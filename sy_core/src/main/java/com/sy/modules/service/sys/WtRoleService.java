package com.sy.modules.service.sys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sy.modules.common.Constants;
import com.sy.modules.dao.sys.SysMenuMapper;
import com.sy.modules.dao.sys.WtRoleMapper;
import com.sy.modules.entity.sys.SysMenu;
import com.sy.modules.entity.sys.WtRole;
import com.sy.modules.entity.vo.SysMenuVo;
import com.sy.modules.entity.vo.WtRoleVo;

/**
 * <p>User: sss
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */

@Service
public class WtRoleService {
	
	@Autowired
	private WtRoleMapper rolemapper;
	
	@Autowired
	private SysMenuMapper sysmenumapper;
	
	
	//查询所有角色
	public PageInfo<WtRole> findAllRolesCategoriesByPage(WtRoleVo wtRoleVo) {
		List<WtRole> list = new ArrayList<WtRole>(0);
		if (null != wtRoleVo) {
			wtRoleVo.setDelState(Constants.ISDELSTATE);
			list = rolemapper.selectByExampleByPage(wtRoleVo.toExample());
		}
		return 	new PageInfo<WtRole>(list);
	}
	
	//当前角色下的所有菜单
	public List<SysMenu> findAllMenusBuRoleId(String roleidparam){
		List<Integer> rIdList=new ArrayList<>();
		List<String> roleIdList=String2List(roleidparam);
		for(String s : roleIdList){
			rIdList.add(Integer.parseInt(s));
		}
		SysMenuVo menuvo=new SysMenuVo();
		menuvo.setMenuList(rIdList);
		return sysmenumapper.selectByExample(menuvo.toExample());
	}
	
	//根据角色id返回菜单id的list
	public List<String> findAllMenuIdByRoleId(Integer roleId){
		List<String> sList=new ArrayList<>();
		if(null!=roleId && roleId>0){
			WtRole role=rolemapper.selectByPrimaryKey(roleId);
			String menuIdStr=role.getWtRMenuids();
			sList=String2List(menuIdStr);
		}
		return sList;
	}

	private List<String> String2List(String param){
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotBlank(param)){
			String[] arr=param.split(",");
			list=Arrays.asList(arr);
		}
		return list;
	}
	
	//根据role id 查询角色信息
	public WtRole findRoleInfoByRId(Integer roleId){
		return rolemapper.selectByPrimaryKey(roleId);
	}
	
	public int saveRole(WtRole record){
		return rolemapper.insertSelective(record);
	}
	
	public int updateRole(WtRole record){
		return rolemapper.updateByPrimaryKey(record);
	}
	
	//假删除角色
	public int deleteRole(Integer roleId){
		WtRole role =new WtRole();
		role.setWtRId(roleId);
		role.setDelState(Constants.DELSTATE);
		return rolemapper.updateByPrimaryKeySelective(role);
	}
	
	public List<WtRole> findAllRoles(){
		return rolemapper.selectAllRoles();
	}
	
    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
  //  Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
  //  Set<String> findPermissions(Long[] roleIds);
}
