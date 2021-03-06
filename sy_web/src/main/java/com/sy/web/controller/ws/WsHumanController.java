package com.sy.web.controller.ws;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.vo.ws.WsHumanVo;
import com.sy.modules.entity.ws.WsHuman;
import com.sy.modules.service.ws.WsHumanService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.PageSet;

/**
 *会员
 *#@author LHL 2013-9-5 
 */
@Controller
@RequestMapping(value ="/ws")
public class WsHumanController extends PageSet {
	
	private static final Logger log=LoggerFactory.getLogger(WsHumanController.class);
	@Autowired 
	private WsHumanService humanService;
	
	/**
	 * 分页查询会员信息
	 * @param request
	 * @param paging
	 * @return
	 */
	@RequestMapping(value="/showHuman")
	public String showhuman(@ModelAttribute WsHumanVo humanVo, HttpServletRequest request) throws ParseException{
		log.info("-----entering---method---WsHumanController---showhuman----");
		//分页查询参数
		PageInfo<WsHuman> humanlist=humanService.findAllHumansByPage(humanVo);
		request.setAttribute("humanList",humanlist);
		log.info("-----leaving---method---WsHumanController---showhuman-----");
		return "ws/human/human";//返回的jsp页面
	}
	
	@RequestMapping(value="/preAddHuman")
	public String preAddHuman(){
		return "ws/human/add_human";
	}
	/**
	 * 添加会员信息
	 * @param response
	 * @param request
	 * @param human
	 */
	@RequestMapping(value="/addHuman")
	@ResponseBody
	public String addhuman(HttpServletRequest request,@ModelAttribute WsHuman human) {
		//获取用户id
		WsHuman wsHuman=humanService.findByAccount(human.getHumanAccount());
		if(null!=wsHuman && StringUtils.isNotBlank(wsHuman.getHumanAccount()))
		{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_USER_EXIST,null,null,null,null);
		}
		else
		{
			boolean success = humanService.addHuman(human);
			if(success){ 
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS,Constants.REL_HUMANMANAGER,null,Constants.CLOSECURRENT,"ws/showHuman");
			}else{ 
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL,null,null,null,null);
			}
		}
	}
	/**
	 * 删除会员
	 * @param request
	 * @param response
	 * @param humanid
	 * @throws IOException
	 */
	@RequestMapping(value="/{hId}/deleteHuman")
	@ResponseBody
	public String deletehuman(@PathVariable Integer hId){
		int flag = -1;
		if(null != hId){
			WsHuman human=new WsHuman();
			human.setHumanId(hId.longValue());
			flag=humanService.deleteHuman(human);
		}
		if(flag>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS,null,null,Constants.FORWARD,"ws/showHuman");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL,null,null,Constants.FORWARD,"ws/showHuman");
		}
	}
	
	/**
	 * 查看会员详细信息
	 */
	@RequestMapping(value="/humanDetails")
	public String humanDetails(HttpServletRequest request,@RequestParam(value="id")Long id) {
		WsHuman human = humanService.findHuman(id.intValue());
		request.setAttribute("human",human);
		return "ws/human/upd_human"; 
	}
	
	/**
	 * 修改会员信息
	 * @throws IOException 
	 */	
	@RequestMapping(value = "/updateHuman")
	@ResponseBody
	public String updatehuman(HttpServletRequest request,@ModelAttribute WsHuman human){
		int flag=-1;
		if(null != human){
			flag=humanService.updateHuman(human);
		}
		if(flag>0){
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_HUMANMANAGER, null, Constants.CLOSECURRENT,"ws/showHuman");
		}else{
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, Constants.REL_HUMANMANAGER, null, Constants.CLOSECURRENT,"ws/showHuman");
		}
		
	}
	
	/*
	 * app访问
	 * 添加会员信息
	 * @param response
	 * @param request
	 * @param human
	 * @throws UnsupportedEncodingException 
	 */
	/*@RequestMapping(value="/register")
	public String register(HttpServletResponse response,HttpServletRequest request,@ModelAttribute WsHuman human) throws UnsupportedEncodingException {
		//		获取用户id
		long id=Long.valueOf(request.getParameter("id"));
		WsHumanUser wu=new WsHumanUser();
		wu.setUserId(id);
		human.setHumanAccount(human.getHumanAccount());
		human.setHumanPassword(human.getHumanPassword());
		boolean success = humanService.addHuman(human,wu);
		if(success){ 
			return "ws/app/success";
		}else{ 
			return "ws/app/fail";
		}
	}*/
	/*
	 * app访问
	 * 会员登录
	 * @param response
	 * @param request
	 * @param human
	 * @throws UnsupportedEncodingException 
	 */
	/*@RequestMapping(value="wap/login")
	@ResponseBody
	public String login(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
		log.info("entering...WsHumanController...login()");
		Long id=0L;
		String idstr=request.getParameter("id");
		String usernamestr=request.getParameter("username");
		String passwordstr=request.getParameter("password");
		if(StringUtils.isNotBlank(idstr)&&StringUtils.isNotBlank(usernamestr)&&StringUtils.isNotBlank(passwordstr)){
			id=Long.valueOf(idstr);
			WsHuman obj=humanService.login(id,usernamestr, passwordstr);
			Gson gson=new Gson();
			return gson.toJson(obj);
		}
		return null;
	}*/
	/**
	 * 注册会员
	 * @param response
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	/*@RequestMapping(value="wap/registerHuman")
	@ResponseBody
	public String registerHuman(HttpServletResponse response,HttpServletRequest request,@ModelAttribute WsHuman human) throws UnsupportedEncodingException {
		//获取用户id
		long id=Long.valueOf(request.getParameter("id"));
		WsHumanUser wu=new WsHumanUser();
		wu.setUserId(id);
		human.setHumanAccount(human.getHumanAccount());
		human.setHuman_password(human.getHuman_password());
		human.setHuman_question(human.getHuman_question());
		human.setHuman_name(human.getHuman_name());
	//	human.setHuman_phone(human.getHuman_phone());
		//human.setHuman_address(human.getHuman_address());
		List<WsHuman> wsHuman=humanService.findByAccount(human.getHumanAccount());
		String mat="[A-Za-z0-9_]*";
		Pattern  pattern=Pattern.compile(mat);
		if(pattern.matcher(human.getHumanAccount()).matches())
         {
			if (wsHuman.size() > 0) {
				return "exists";
			} else {
				boolean success = humanService.addHuman(human, wu);
				if (success) {
					return "success";
				} else {
					return "fail";
				}
			}
		}
		else{return "fail";}
			
	}*/
}
