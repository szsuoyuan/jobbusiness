package com.sy.web.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sy.commons.entity.HResult;
import com.sy.commons.utils.DataTool;
import com.sy.modules.entity.sys.SysEmployee;
import com.sy.modules.entity.vo.SysEmployeeVo;
import com.sy.modules.entity.ws.WsOrder;
import com.sy.modules.service.sys.SysEmployeeService;
import com.sy.modules.service.ws.WsOrderService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;

/**
 * 报名接口
 * @author sss
 */
@Controller
@RequestMapping(value = "/api/wap")
public class ApiWsOrderController extends PageSet {
	
	@Autowired
	private WsOrderService orderService;
	
	@Autowired
	private SysEmployeeService emService;
	
	private static final Logger log = LoggerFactory.getLogger(ApiWsOrderController.class);
	
	//查看所有经纪人
	@RequestMapping(value = "/searchAllEmployees")
	@ResponseBody
	public HResult<PageInfo<SysEmployee>> searchAllEmployees(Model model,@ModelAttribute SysEmployeeVo emVo, HttpServletRequest request){
		HResult<PageInfo<SysEmployee>> result = new HResult<>(true, "");
		PageInfo<SysEmployee> emlist= emService.findAllSysEmployeesByPage(emVo);
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(emlist);
		return result;
	}
	
	
	//报名
	@RequestMapping(value = "/enterCompanyAndJob")
	@ResponseBody
	public HResult<WsOrder>  enterCompanyAndJob(HttpServletRequest request,@ModelAttribute WsOrder order){
		log.info("---entering---ApiWsOrderController---enterCompanyAndJob---");
		HResult<WsOrder> result = new HResult<WsOrder>(true, "");
		int flag = -1;
		if (null != order) {
			if(StringUtils.isBlank(order.getoNumber())){
				order.setoNumber(DataTool.createCoding());
			}
			flag = orderService.saveWsOrder(order);
		}
		if (flag > 0) {
			result.setCode(Constants.SUCCESS);
			result.setValue(Constants.MSG_ADD_SUCCESS);
		} else {
			result.setCode(Constants.ERROR);
			result.setValue(Constants.MSG_ADD_FAIL);
			result.setResult(false);
		}
		log.info("---leaving---ApiWsOrderController---enterCompanyAndJob---");
		return result;
	}

}
