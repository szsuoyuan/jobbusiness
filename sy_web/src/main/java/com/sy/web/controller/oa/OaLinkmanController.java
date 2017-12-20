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
import com.sy.modules.entity.oa.OaLinkman;
import com.sy.modules.entity.vo.oa.OaLinkmanVo;
import com.sy.modules.service.oa.OaCustomerService;
import com.sy.modules.service.oa.OaLinkmanService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;

@Controller
@RequestMapping("/oa")
public class OaLinkmanController {

	@Autowired
	private OaLinkmanService linkmanservice;
	
	@Autowired
	private OaCustomerService customerservice;

	// find all customers by page
	@RequestMapping(value = "/findAllLinkmansByPage/{cId}", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllLinkmansByPageWithCid(Model model,@PathVariable Long cId, @ModelAttribute OaLinkmanVo linkmanVo, HttpServletRequest request) {
		if(null !=cId && cId>0){
			linkmanVo.setcId(cId);
			PageInfo<OaLinkman> linkmanlist = linkmanservice.findAllLinkMansByPage(linkmanVo);
			model.addAttribute("linkmanlist", linkmanlist);
			model.addAttribute("cId", cId);
			model.addAttribute("customer", customerservice.findCustomer(cId.intValue()));
		}
		return "oa/linkmanlist";
	}
	
	@RequestMapping(value = "/findAllLinkmansByPage", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllLinkmansByPage(Model model, @ModelAttribute OaLinkmanVo linkmanVo, HttpServletRequest request) {
			PageInfo<OaLinkman> linkmanlist = linkmanservice.findAllLinkMansByPage(linkmanVo);
			for(OaLinkman m:linkmanlist.getList()){
				OaCustomer customer= customerservice.findCustomer(m.getcId().intValue());
				m.setcCustomer(customer.getcName());
			}
			model.addAttribute("linkmanlist", linkmanlist);
		return "oa/linkmanlistform";
	}

	// prepare add
	@RequestMapping(value = "/precreatelinkman", method = { RequestMethod.GET,RequestMethod.POST })
	public String precreatelinkman(Model model,HttpServletRequest request) {
		String cidstr=request.getParameter("lmid");
		if(StringUtils.isNotBlank(cidstr)){
			Integer lmId=Integer.parseInt(cidstr);
			model.addAttribute("lmId", lmId);
		}
		return "oa/addlinkman";
	}

	// save customer info
	@RequestMapping(value = "/saveLinkman", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String saveCustomer(Model model, HttpServletRequest request,@ModelAttribute OaLinkman linkman) {
		int flag = -1;
		String cIdStr=request.getParameter("lmId");
		if (null != linkman) {
			if(StringUtils.isNotBlank(cIdStr)){
				linkman.setcId(Long.parseLong(cIdStr));
			}
			flag = linkmanservice.saveLinkman(linkman);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_LINKMANMANAGER,null, Constants.CLOSECURRENT, "oa/findAllLinkmansByPage/"+linkman.getcId());
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
		}
	}

	// delete customer
	@RequestMapping(value = "/{cid}/deleteLinkman")
	@ResponseBody
	public String deleteCustomer(@PathVariable Integer cid,HttpServletRequest request) {
		int flag = -1;
		if (null != cid && cid > 0) {
			OaLinkman linkman = new OaLinkman();
			linkman.setLmId(cid.longValue());
			flag = linkmanservice.deleteLinkman(linkman);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_LINKMANMANAGER,null, null, null);
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_LINKMANMANAGER,null, null, null);
		}
	}

	@RequestMapping(value = "/findLinkmanById/{lmid}")
	public String findLinkmanById(@PathVariable("lmid") Integer lmid,Model model, HttpServletRequest request) {
		if (null != lmid) {
			OaLinkman linkman = linkmanservice.findLinkman(lmid);
			model.addAttribute("linkman", linkman);
		}
		return "oa/preupdlinkman";
	}

	// update customer
	@RequestMapping(value = "/saveLinkmanByUpd")
	@ResponseBody
	public String saveLinkmanByUpd(Model model,@ModelAttribute OaLinkman linkman, HttpServletRequest request) {
		int flag = -1;
		if (null != linkman) {
			flag = linkmanservice.updateLinkman(linkman);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_LINKMANMANAGER,null, Constants.CLOSECURRENT, "oa/findAllLinkmansByPage/"+linkman.getcId());
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
		}
	}

}
