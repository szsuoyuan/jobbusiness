package com.sy.web.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.sys.WtRole;
import com.sy.modules.entity.vo.WtRoleVo;
import com.sy.modules.service.sys.SysMenuService;
import com.sy.modules.service.sys.UserService;
import com.sy.modules.service.sys.WtRoleService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.SessionUtil;

/**
 * <p>
 * User: sss
 * <p>
 * Date: 14-2-14
 * <p>
 * Version: 1.0
 */
@Controller
@RequestMapping("/sys")
public class WtRoleController {

	@Autowired
	private WtRoleService roleservice;
	
	@Autowired
	private SysMenuService menuservice;
	
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/findAllRoles", method = { RequestMethod.GET,RequestMethod.POST })
	public String searchWtRolesByPage(Model model,@ModelAttribute WtRoleVo wtRoleVo, HttpServletRequest request) {
		Long sysuserid=SessionUtil.getUserId(request);
		if(sysuserid>0){
			wtRoleVo.setSysUserId(sysuserid.intValue());
		}
		PageInfo<WtRole> rolelist = roleservice.findAllRolesCategoriesByPage(wtRoleVo);
		model.addAttribute("rolelist", rolelist);
		return "sys/rolelist";

	}

	@RequestMapping(value = "/precreate", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		setCommonData(model);
		model.addAttribute("op", "新增");
		return "sys/editrole";
	}
	
	@RequestMapping(value = "/createsave", method = RequestMethod.POST)
	@ResponseBody
	public String createRoleAndSave(Model model,HttpServletRequest request) {
		String rolename=request.getParameter("wtRName");
		String roledescription=request.getParameter("wtRDescription");
		//角色菜单id
		String menustr="";
		String[] wtRMenuids=request.getParameterValues("sysmenu");
		for(String s:wtRMenuids){
			menustr+=s+",";
		}
		WtRole role=new WtRole();
		role.setWtRName(rolename);
		role.setWtRDescription(roledescription);
		role.setWtRMenuids(menustr.trim());
		role.setSysUserId(SessionUtil.getUserId(request).intValue());
		role.setDelState(Constants.ISDELSTATE);
		int num=roleservice.saveRole(role);
		if(num>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS,"005",null,Constants.CLOSECURRENT,"sys/findAllRoles");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL,null,null,null,null);
		}
	}
	
	//查询当前角色的菜单
	@RequestMapping(value="/searchMenusByRId",method= RequestMethod.GET)
	public String searchMenusByRId(Model model,HttpServletRequest request){
		Integer roleid=null;
		List<String> rolemenuList=null;//当前角色对应的菜单id
		//所有菜单
		model.addAttribute("menuList", menuservice.findAllSysMenus()); 
		//获取角色id
		String ridstr=request.getParameter("rid");
		if(StringUtils.isNotEmpty(ridstr)){
			roleid=Integer.parseInt(ridstr);
			WtRole role= roleservice.findRoleInfoByRId(roleid);
			rolemenuList= roleservice.findAllMenuIdByRoleId(roleid);
			request.setAttribute("rolemenuList", rolemenuList);
			request.setAttribute("wtrole", role);
			request.setAttribute("rid", roleid);
		}
		return "sys/powermanager";
	}
	
	private void setCommonData(Model model) {
		 model.addAttribute("menuList", menuservice.findAllSysMenus()); 
	}

	
	//删除角色
	@RequestMapping(value="/{rid}/delete")
	@ResponseBody
	public String deleteRoleInfo(@PathVariable("rid") Long rid, Model model) {
		//判断当前角色下是否有用户
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", rid);
		Long num=userservice.findCountByParam(map);
		if(num > 0){
			 return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL_TIP, null, "",Constants.FORWARD, "sys/findAllRoles");
		}else{
			//执行删除
			roleservice.deleteRole(rid.intValue());
	        return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, null, "",Constants.FORWARD, "sys/findAllRoles");
		}
    }
	
	@RequestMapping(value = "/updatesave", method = RequestMethod.POST)
	@ResponseBody
	public String updateRoleAndSave(Model model,HttpServletRequest request) {
		String roleId=request.getParameter("wtRId");
		String rolename=request.getParameter("wtRName");
		String roledescription=request.getParameter("wtRDescription");
		//角色菜单id
		String menustr="";
		String[] wtRMenuids=request.getParameterValues("sysmenu");
		for(String s:wtRMenuids){
			menustr+=s+",";
		}
		WtRole role=new WtRole();
		role.setWtRId(Integer.parseInt(roleId));
		role.setWtRName(rolename);
		role.setWtRDescription(roledescription);
		role.setWtRMenuids(menustr.trim());
		role.setSysUserId(SessionUtil.getUserId(request).intValue());
		role.setDelState(Constants.ISDELSTATE);
		int num=roleservice.updateRole(role);
		if(num>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS,"005",null,Constants.CLOSECURRENT,"sys/findAllRoles");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL,null,null,null,null);
		}
	}
	
	
	/*
	 * 
	 * @Autowired private RoleService roleService;
	 * 
	 * @Autowired private ResourceService resourceService;
	 * 
	 * @RequiresPermissions("role:view")
	 * 
	 * @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}) public
	 * String list(Model model) { model.addAttribute("roleList",
	 * roleService.findAll()); return "role/rolelist"; }
	 * 
	 * @RequiresPermissions("role:create")
	 * 
	 * @RequestMapping(value = "/create", method = RequestMethod.GET) public
	 * String showCreateForm(Model model) { setCommonData(model);
	 * model.addAttribute("role", new Role()); model.addAttribute("op", "新增");
	 * return "role/editrole"; }
	 * 
	 * @RequiresPermissions("role:create")
	 * 
	 * @RequestMapping(value = "/create")
	 * 
	 * @ResponseBody public String create(Role role, RedirectAttributes
	 * redirectAttributes) { roleService.createRole(role); //
	 * redirectAttributes.addFlashAttribute("msg", "新增成功"); // return
	 * "redirect:/role"; return
	 * JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants
	 * .MSG_ADD_SUCCESS, Constants.MSG_REL_ROLE, null,Constants.CLOSECURRENT,
	 * "role"); }
	 * 
	 * @RequiresPermissions("role:update")
	 * 
	 * @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	 * public String showUpdateForm(@PathVariable("id") Long id, Model model) {
	 * setCommonData(model); model.addAttribute("role",
	 * roleService.findOne(id)); model.addAttribute("op", "修改"); return
	 * "role/editrole"; }
	 * 
	 * @RequiresPermissions("role:update")
	 * 
	 * @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	 * public String update(Role role, RedirectAttributes redirectAttributes) {
	 * roleService.updateRole(role); redirectAttributes.addFlashAttribute("msg",
	 * "修改成功"); return "redirect:/role"; }
	 * 
	 * @RequiresPermissions("role:delete")
	 * 
	 * @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	 * public String showDeleteForm(@PathVariable("id") Long id, Model model) {
	 * setCommonData(model); model.addAttribute("role",
	 * roleService.findOne(id)); model.addAttribute("op", "删除"); return
	 * "role/edit"; }
	 * 
	 * @RequiresPermissions("role:delete")
	 * 
	 * @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	 * public String delete(@PathVariable("id") Long id, RedirectAttributes
	 * redirectAttributes) { roleService.deleteRole(id);
	 * redirectAttributes.addFlashAttribute("msg", "删除成功"); return
	 * "redirect:/role"; }
	 * 
	 * private void setCommonData(Model model) {
	 * model.addAttribute("resourceList", resourceService.findAll()); }
	 */
}
