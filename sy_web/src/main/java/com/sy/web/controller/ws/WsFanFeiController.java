package com.sy.web.controller.ws;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.vo.ws.WsFanFeiVo;
import com.sy.modules.entity.ws.WsFanFei;
import com.sy.modules.service.ws.WsReturnFeeService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.PageSet;


@Controller
@RequestMapping(value ="/ws")
public class WsFanFeiController extends PageSet {
	
		@Autowired
		private WsReturnFeeService feeService;
		
		// find all fee by page
		@RequestMapping(value = "/findAllReturnFeeByPage", method = {RequestMethod.GET, RequestMethod.POST })
		public String findAllReturnFeeByPage(Model model,@ModelAttribute WsFanFeiVo fanfeiVo, HttpServletRequest request) {
			PageInfo<WsFanFei> feeList = feeService.findAllFanFeiByPage(fanfeiVo);
			model.addAttribute("feelist", feeList);
			return "ws/fee/feelist";
		}
		
		// prepare add
		@RequestMapping(value = "/preaddfee", method = { RequestMethod.GET,RequestMethod.POST })
		public String preaddfee(Model model,HttpServletRequest request) {
			return "ws/fee/addfee";
		}
		
		// save fee info
		@RequestMapping(value = "/saveFee", method = { RequestMethod.GET,RequestMethod.POST })
		@ResponseBody
		public String saveFee(Model model, HttpServletRequest request,@ModelAttribute WsFanFei fee) {
			int flag = -1;
			if (null != fee) {
				flag = feeService.saveFanFei(fee);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_FEEMANAGER,null, Constants.CLOSECURRENT, "ws/findAllReturnFeeByPage");
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
			}
		}
		
		
		// delete fee
		@RequestMapping(value = "/{fId}/deleteFee")
		@ResponseBody
		public String deleteFee(@PathVariable("fId") Integer fId,HttpServletRequest request) {
			int flag = -1;
			if (null != fId && fId > 0) {
				WsFanFei fee=new WsFanFei();
				fee.setfId(fId);
				flag = feeService.deleteFanFei(fee);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_FEEMANAGER,null, null, null);
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_FEEMANAGER,null, null, null);
			}
		}

		//find fee by id
		@RequestMapping(value = "/findFeeById/{fId}")
		public String findFeeById(@PathVariable("fId") Integer fId,Model model, HttpServletRequest request) {
			if (null != fId) {
				WsFanFei fee = feeService.findFanFei(fId);
				model.addAttribute("fee", fee);
			}
			return "ws/fee/preupdfee";
		}

		// update fee
		@RequestMapping(value = "/saveFeeByUpd")
		@ResponseBody
		public String saveFeeByUpd(Model model,@ModelAttribute WsFanFei fee, HttpServletRequest request) {
			int flag = -1;
			if (null != fee) {
				flag = feeService.updateFanFei(fee);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_FEEMANAGER,null, Constants.CLOSECURRENT, "ws/findAllReturnFeeByPage");
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
			}
		}


}
