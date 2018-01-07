package com.sy.web.controller.api;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sy.commons.entity.HResult;
import com.sy.modules.entity.ws.WsNews;
import com.sy.modules.entity.ws.WsNewsClass;
import com.sy.modules.service.ws.WsNewsClassService;
import com.sy.modules.service.ws.WsNewsService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.DataTool;
import com.sy.web.commons.PageSet;

/**
 * 消息列表
 * @author sss
 */
@Controller
@RequestMapping(value = "/api/wap")
public class ApiNewsClassController extends PageSet {
	private static final Logger log = LoggerFactory.getLogger(ApiNewsClassController.class);
	
	@Autowired
	private WsNewsClassService newsclass;
	
	@Autowired 
	private WsNewsService newservice;
	
	//查询所有分类
	@RequestMapping(value = "/searchNewsClass")
	@ResponseBody
	public HResult<List<WsNewsClass>> searchNewsClass(HttpServletRequest request) {
		log.info("-----entering---method---ApiNewsClassController---searchNewsClass-----");
		HResult<List<WsNewsClass>> result = new HResult<>(true, "");
		List<WsNewsClass> newsClassList = newsclass.getAllClass(new Long(1));
		result.setCode(Constants.SUCCESS);
		result.setObjValue(newsClassList);
		result.setValue(Constants.MSG_GET_SUCCESS);
		
		log.info("-----leaving---method---ApiNewsClassController---searchNewsClass-----");
		return result;
		
	}
	
	@RequestMapping(value = "/searchNewsByClass")
	@ResponseBody
	public HResult<List<WsNews>> searchNewsByClass(HttpServletRequest request,@RequestParam("newsClass") Integer newsClass) {
		log.info("-----entering---method---ApiNewsClassController---searchNewsByClass-----");
		HResult<List<WsNews>> result = new HResult<>(true, "");
		Map<String,Object> param = DataTool.getParam(request,"newsClass");
		param.put("userid",new Long(1));
		this.setPagination(request, param);
		List<WsNews> newsList=newservice.findAllNewsByPage(param);
		result.setCode(Constants.SUCCESS);
		result.setObjValue(newsList);
		result.setValue(Constants.MSG_GET_SUCCESS);
		log.info("-----leaving---method---ApiNewsClassController---searchNewsByClass-----");
		return result;
	
	}
	
	@RequestMapping(value = "/searchNewsDetailById")
	@ResponseBody
	public HResult<WsNews> searchNewsDetailById(HttpServletRequest request,@RequestParam("nId") Integer nId) {
		log.info("-----entering---method---ApiNewsClassController---searchNewsDetailById-----");
		HResult<WsNews> result = new HResult<>(true, "");
		WsNews newsdetail=newservice.findById(nId.longValue());
		result.setCode(Constants.SUCCESS);
		result.setObjValue(newsdetail);
		result.setValue(Constants.MSG_GET_SUCCESS);
		log.info("-----leaving---method---ApiNewsClassController---searchNewsDetailById-----");
		return result;
	
	}
	
	
	
}
