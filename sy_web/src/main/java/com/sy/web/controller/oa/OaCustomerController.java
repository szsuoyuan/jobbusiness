package com.sy.web.controller.oa;

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
import com.sy.modules.entity.oa.OaCustomer;
import com.sy.modules.entity.sys.SysUser;
import com.sy.modules.entity.vo.oa.OaCustomerVo;
import com.sy.modules.service.oa.OaCustomerService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.SessionUtil;

@Controller
@RequestMapping("/oa")
public class OaCustomerController {

	@Autowired
	private OaCustomerService customerservice;

	// find all customers by page
	@RequestMapping(value = "/findAllCustomersByPage", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllCustomersByPage(Model model,@ModelAttribute OaCustomerVo customVo, HttpServletRequest request) {
		SysUser user = SessionUtil.getLoginUser(request);
		if (null != user) {
			customVo.setSysUserId(user.getId().intValue());
		}
		PageInfo<OaCustomer> customlist = customerservice.findAllCustomersByPage(customVo);
		model.addAttribute("customlist", customlist);
		return "oa/customerlist";
	}

	// prepare add
	@RequestMapping(value = "/precreatecustomer", method = { RequestMethod.GET,RequestMethod.POST })
	public String precreatecustomer(Model model,HttpServletRequest request) {
		String param=request.getParameter("param");
		SysUser user = SessionUtil.getLoginUser(request);
		if(null !=user && StringUtils.isNotBlank(user.getUsername())) {
			model.addAttribute("userName", user.getUsername());
		}
		if(StringUtils.isNotBlank(param)) {
			if("sea".equals(param)) {
				model.addAttribute("action","oa/saveCustomerInSea");
			}
			if("cus".equals(param)) {
				model.addAttribute("action","oa/saveCustomer");
			}
		}
		return "oa/addcustomer";
	}

	// save customer info
	@RequestMapping(value = "/saveCustomer", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String saveCustomer(Model model, HttpServletRequest request,@ModelAttribute OaCustomer customer) {
		int flag = -1;
		SysUser user = SessionUtil.getLoginUser(request);
		if (null != customer) {
			if (StringUtils.isNotBlank(user.getUsername())) {
				customer.setSysUserId(user.getId());
				customer.setSysUserName(user.getUsername());
				customer.setSeaStatus(Constants.ISDELSTATE.byteValue());
			}
			flag = customerservice.saveCustomer(customer);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_CUSTOMERMANAGER,null, Constants.CLOSECURRENT, "oa/findAllCustomersByPage");
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
		}
	}

	
	
	// delete customer
	@RequestMapping(value = "/{cid}/deleteCustomer")
	@ResponseBody
	public String deleteCustomer(@PathVariable Integer cid,HttpServletRequest request) {
		int flag = -1;
		if (null != cid && cid > 0) {
			OaCustomer custom = new OaCustomer();
			custom.setcId(cid.longValue());
			flag = customerservice.deleteCustomer(custom);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_CUSTOMERMANAGER,null, null, null);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_CUSTOMERMANAGER,null, null, null);
		}
	}

	@RequestMapping(value = "/{cid}/returnSeaCustomer")
	@ResponseBody
	public String returnSeaCustomer(@PathVariable Integer cid,HttpServletRequest request) {
		int flag = -1;
		if (null != cid && cid > 0) {
			OaCustomer custom = new OaCustomer();
			custom.setcId(cid.longValue());
			flag = customerservice.returnSeaCustomer(custom);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_RETURN_SEA_SUCCESS, Constants.REL_CUSTOMERMANAGER,null, null, null);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_RETURN_SEA_FAIL, Constants.REL_CUSTOMERMANAGER,null, null, null);
		}
	}
	@RequestMapping(value = "/findCustomerById/{cid}")
	public String findCustomerById(@PathVariable("cid") Integer cid,Model model, HttpServletRequest request) {
		if (null != cid) {
			OaCustomer customer = customerservice.findCustomer(cid);
			model.addAttribute("customer", customer);
		}
		return "oa/preupdcustomer";
	}

	// update customer
	@RequestMapping(value = "/saveCustomerByUpd")
	@ResponseBody
	public String saveEmployeeByUpd(Model model,@ModelAttribute OaCustomer customer, HttpServletRequest request) {
		int flag = -1;
		if (null != customer) {
			flag = customerservice.updateCustomer(customer);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_CUSTOMERMANAGER,null, Constants.CLOSECURRENT, "oa/findAllCustomersByPage");
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
		}
	}
	
	//-------------------------------------sea--customer---------------------------------------------------------------
	
	// find all customers by page in sea
		@RequestMapping(value = "/findAllCustomersByPageInSea", method = {RequestMethod.GET, RequestMethod.POST })
		public String findAllCustomersByPageInSea(Model model,@ModelAttribute OaCustomerVo customVo, HttpServletRequest request) {
			SysUser user = SessionUtil.getLoginUser(request);
			if (null != user) {
				customVo.setSysUserId(user.getParentid());
			}
			PageInfo<OaCustomer> customlist = customerservice.findAllCustomersByPageInSea(customVo);
			model.addAttribute("customlist", customlist);
			return "oa/seacustomerlist";
		}
	
	
		// save customer info in sea
		@RequestMapping(value = "/saveCustomerInSea", method = { RequestMethod.GET,RequestMethod.POST })
		@ResponseBody
		public String saveCustomerInSea(Model model, HttpServletRequest request,@ModelAttribute OaCustomer customer) {
			int flag = -1;
			SysUser user = SessionUtil.getLoginUser(request);
			if (null != customer) {
				if (StringUtils.isNotBlank(user.getUsername())) {
					customer.setSysUserId(user.getId());
					customer.setSysUserName(user.getUsername());
					customer.setSeaStatus(Constants.DELSTATE.byteValue());
				}
				flag = customerservice.saveCustomer(customer);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_SEACUSTOMERMANAGE,null, Constants.CLOSECURRENT, "oa/findAllCustomersByPageInSea");
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
			}
		}
	
		
		// delete customer
		@RequestMapping(value = "/{cid}/deleteCustomerInSea")
		@ResponseBody
		public String deleteCustomerInSea(@PathVariable Integer cid,HttpServletRequest request) {
			int flag = -1;
			if (null != cid && cid > 0) {
				OaCustomer custom = new OaCustomer();
				custom.setcId(cid.longValue());
				flag = customerservice.deleteCustomer(custom);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_SEACUSTOMERMANAGE,null, null, null);
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_SEACUSTOMERMANAGE,null, null, null);
			}
		}
	
	
		@RequestMapping(value = "/findCustomerByIdInSea/{cid}")
		public String findCustomerByIdInSea(@PathVariable("cid") Integer cid,Model model, HttpServletRequest request) {
			if (null != cid) {
				OaCustomer customer = customerservice.findCustomer(cid);
				model.addAttribute("customer", customer);
			}
			return "oa/preupdcustomerinsea";
		}
	
		
		// update customer
		@RequestMapping(value = "/saveCustomerByUpdInSea")
		@ResponseBody
		public String saveCustomerByUpdInSea(Model model,@ModelAttribute OaCustomer customer, HttpServletRequest request) {
			int flag = -1;
			if (null != customer) {
				flag = customerservice.updateCustomer(customer);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_SEACUSTOMERMANAGE,null, Constants.CLOSECURRENT, "oa/findAllCustomersByPageInSea");
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
			}
		}
	
	//receive customer
		@RequestMapping(value = "/{cid}/receiveCustomer")
		@ResponseBody
		public String receiveCustomer(@PathVariable Integer cid,HttpServletRequest request) {
			SysUser user = SessionUtil.getLoginUser(request);
			int flag = -1;
			if (null != cid && cid > 0) {
				OaCustomer custom = new OaCustomer();
				custom.setcId(cid.longValue());
				if(null != user && null !=user.getId()){
					custom.setSysUserId(user.getId());
				}
				flag = customerservice.receiveCustomer(custom);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_RECEIVE_SUCCESS, Constants.REL_SEACUSTOMERMANAGE,null, null, null);
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_RECEIVE_FAIL, Constants.REL_SEACUSTOMERMANAGE,null, null, null);
			}
		}
		
		@RequestMapping(value = "/findCustomerListByPage", method = {RequestMethod.GET, RequestMethod.POST })
		public String findCustomerListByPage(Model model,@ModelAttribute OaCustomerVo customVo, HttpServletRequest request) {
			PageInfo<OaCustomer> customlist = customerservice.findAllCustomersByPage(customVo);
			model.addAttribute("customlist", customlist);
			return "oa/customerlistform";
		}
	


}
