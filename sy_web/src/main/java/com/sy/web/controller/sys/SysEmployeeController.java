package com.sy.web.controller.sys;

import java.util.Date;

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
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.sys.SysUser;
import com.sy.modules.entity.vo.SysEmployeeVo;
import com.sy.modules.service.sys.SysEmployeeService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.SessionUtil;

@Controller
@RequestMapping("/sys")
public class SysEmployeeController {
	
	@Autowired
	private SysEmployeeService emservice;
	//查询所有员工
	@RequestMapping(value = "/findAllEmployees", method = { RequestMethod.GET,RequestMethod.POST })
	public String findAllEmployees(Model model,@ModelAttribute SysEmployeeVo emVo, HttpServletRequest request) {
		SysUser user=SessionUtil.getLoginUser(request);
		if(null!=user){
			emVo.setSysUserId(user.getParentid());
		}
		PageInfo<SysEmployee> emlist= emservice.findAllSysEmployeesByPage(emVo);
		model.addAttribute("emlist", emlist);
		return "sys/employeelist";
	}
	//预添加
	@RequestMapping(value = "/precreateemp", method = { RequestMethod.GET,RequestMethod.POST })
	public String precreateemp(){
		return "sys/addemp";
	}
	//保存员工信息
	@RequestMapping(value = "/saveEmployee", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String saveEmployee(Model model,HttpServletRequest request,@ModelAttribute SysEmployee em){
		int flag=-1;
		String sysuserId=request.getParameter("user.id");
		SysUser user= SessionUtil.getLoginUser(request);
		if(null!= em){
			em.setCreateTime(new Date());
			em.setUpdateTime(new Date());
			if(StringUtils.isNotBlank(sysuserId)){
				em.setSysUserId(Integer.parseInt(sysuserId));
			}
			if(null !=user && StringUtils.isNotBlank(user.getUsername())){
				em.setCreateName(user.getUsername());
			}
			flag=emservice.saveEmployee(em);
		}
		if(flag>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_ADD_SUCCESS, Constants.REL_EMPLOYEEMANAGE, null,
					Constants.CLOSECURRENT, "sys/findAllEmployees");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR, Constants.MSG_ADD_FAIL,null, null,null, null);
		}
	}
	
	//删除员工
	@RequestMapping(value = "/{eid}/deleteEmployee")
	@ResponseBody
	public 	String deleteEmployee(@PathVariable Integer eid, HttpServletRequest request) {
		int flag =-1;
		if (null != eid && eid>0) {
			SysEmployee emp=new SysEmployee();
			emp.seteId(eid);
			flag=emservice.deleteEmployee(emp);
		}
		if(flag >0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_EMPLOYEEMANAGE, null,null, null);
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_EMPLOYEEMANAGE, null, null,null);
		}
	}
	
	@RequestMapping(value="/findEmpById/{empid}")
	public String searchSysUserByUId(@PathVariable("empid") Integer empid,Model model, HttpServletRequest request){
		if(null !=empid){
			SysEmployee employee=emservice.findEmplyee(empid);
			model.addAttribute("emp",employee);
		}
		return "sys/preupdemp";
	}
	
	//修改员工
	@RequestMapping(value="/saveEmployeeByUpd")
	@ResponseBody
	public String saveEmployeeByUpd(Model model, @ModelAttribute SysEmployee em,HttpServletRequest request){
		int flag=-1;
		String sysuserId=request.getParameter("user.id");
		SysUser user= SessionUtil.getLoginUser(request);
		if(null != em){
			if(StringUtils.isNotBlank(sysuserId)){
				em.setSysUserId(Integer.parseInt(sysuserId));
			}
			if(null !=user && StringUtils.isNotBlank(user.getUsername())){
				em.setUpdateName(user.getUsername());
			}
			flag=emservice.updateEmployee(em);
		}
		if(flag>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS,Constants.REL_EMPLOYEEMANAGE,null,Constants.CLOSECURRENT,"sys/findAllEmployees");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL,null,null,null,null);
		}
	}

}
