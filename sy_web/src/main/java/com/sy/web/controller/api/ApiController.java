package com.sy.web.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sy.commons.entity.HResult;
import com.sy.modules.entity.ws.WsHuman;
import com.sy.modules.exception.ApplicationException;
import com.sy.modules.service.ws.WsHumanService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;

@Controller
@RequestMapping(value = "/api/wap")
public class ApiController extends PageSet {
	private static final Logger log = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private WsHumanService humanService;
	
	//注册会员
	@RequestMapping(value = "/registHuman")
	@ResponseBody
	public HResult<WsHuman> registHuman(HttpServletRequest request,@ModelAttribute WsHuman human) {
		log.info("---entering---method---ApiController---registHuman---");
		WsHuman human_rep=null;
		HResult<WsHuman> result = new HResult<WsHuman>(true, "");
		// 获取表单信息
		if(null !=human && StringUtils.isNotBlank(human.getHumanAccount())) {
			human_rep=humanService.findByAccount(human.getHumanAccount());
		}
		if (null != human_rep) {
			result.setResult(false);
			result.setValue(Constants.MSG_USER_EXIST);
		} else {
			try {
				//创建会员信息
				WsHuman humanobj=new WsHuman();
				humanobj.setHumanAccount(human.getHumanAccount());
				humanobj.setHumanPassword(human.getHumanPassword());
				humanobj.setHumanQuestion(human.getHumanQuestion());//昵称
				humanobj.setHumanSex(human.getHumanSex());//性别
				humanobj.setHumanAnswer(human.getHumanAnswer());//出生年月
				humanService.addHuman(humanobj);
				result.setValue(Constants.MSG_ADD_SUCCESS);
				result.setObjValue(human);
			}catch(Exception e) {
				result.setResult(false);
				result.setValue(e.getMessage());
			}
			
		}
		log.info("---leaving---method---ApiController---registHuman---");
		return result;
	}
	
	//会员登录
	@RequestMapping(value="/doLogin")
	@ResponseBody
	public HResult<WsHuman> doLogin(HttpServletRequest request){
		log.info("---entering---method---ApiController---doLogin---");
		HResult<WsHuman> result = new HResult<WsHuman>(true, "");
		String smaccount = request.getParameter("humanAccount");
		String smpass = request.getParameter("humanPassword");
		try{
			if(StringUtils.isNotEmpty(smaccount)&&StringUtils.isNotEmpty(smpass)){
				WsHuman human=humanService.humanLogin(smaccount, smpass);
				result.setValue(Constants.MSG_LOGIN_SUCCESS);
				result.setObjValue(human);
			}
		} catch (ApplicationException e){
			result.setResult(false);
			result.setValue(e.getMessage());
		}catch(Exception e){
			result.setResult(false);
			result.setValue(e.getMessage());
		}
		log.info("---leaving---method---ApiController---doLogin---");
		return result;
	}
	
	//修改个人信息

}
