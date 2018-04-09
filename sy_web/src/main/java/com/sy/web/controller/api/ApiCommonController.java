package com.sy.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.sy.commons.entity.HResult;
import com.sy.modules.entity.sys.SysComPicture;
import com.sy.modules.entity.vo.ws.WsFanFeiVo;
import com.sy.modules.entity.ws.WsAbout;
import com.sy.modules.entity.ws.WsFanFei;
import com.sy.modules.entity.ws.WsSupplier;
import com.sy.modules.service.sys.SysComPictureService;
import com.sy.modules.service.ws.WsAboutService;
import com.sy.modules.service.ws.WsReturnFeeService;
import com.sy.modules.service.ws.WsSupplierService;
import com.sy.modules.utils.HtmlUtil;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;

@Controller
@RequestMapping(value = "/api/wap")
public class ApiCommonController extends PageSet {
	
	@Autowired
	private WsReturnFeeService feeService;
	
	@Autowired
	private WsSupplierService suppservice;
	
	@Autowired 
	private WsAboutService aboutservice;
	
	@Autowired
	private SysComPictureService compservice;
	
	//返费列表
	@RequestMapping(value = "/searchAllReturnFee")
	@ResponseBody
	public HResult<PageInfo<WsFanFei>> searchAllReturnFee(HttpServletRequest request,@ModelAttribute WsFanFeiVo feeVo) {
		HResult<PageInfo<WsFanFei>> result = new HResult<>(true, "");
		PageInfo<WsFanFei> feelist= feeService.findAllFanFeiByPage(feeVo);
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(feelist);
		return result;
		
	}
	
	//所有门店
	@RequestMapping(value = "/searchAllStores")
	@ResponseBody
	public HResult<List<WsSupplier>> searchAllStores(HttpServletRequest request) {
		HResult<List<WsSupplier>> result = new HResult<>(true, "");
		Map<String,Object> map=new HashMap<String,Object>();
		this.setPagination(request, map);
		List<WsSupplier> supplist=suppservice.findAllSupplier(map);
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(supplist);
		return result;
	}
	
	//查看门店详情
	@RequestMapping(value = "/searchStoreInfoById")
	@ResponseBody
	public HResult<WsSupplier> searchStoreInfoById(HttpServletRequest request,@RequestParam("sId") Integer sId) {
		HResult<WsSupplier> result = new HResult<>(true, "");
		WsSupplier supplier=suppservice.findSupplierDetailInfo(sId);
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(supplier);
		return result;
	}
	

	//关于我们
	@RequestMapping(value = "/searchCompanyInfo")
	@ResponseBody
	public HResult<WsAbout> searchCompanyInfo(HttpServletRequest request) {
		HResult<WsAbout> result = new HResult<>(true, "");
		Map<String,Object> map=new HashMap<String,Object>();
		this.setPagination(request, map);
		WsAbout info = aboutservice.selectAbout(1L);
		info.setAbout(HtmlUtil.delHTMLTag(info.getAbout()));
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(info);
		return result;
	}
	
	/**
	 * 查询所有首页轮播图 return json
	 */
	@RequestMapping(value = "/findComPicByJson")
	@ResponseBody
	public  HResult<List<SysComPicture>> findComPicByJson(HttpServletRequest request) {
		HResult<List<SysComPicture>> result = new HResult<>(true, "");
		List<SysComPicture> comlist = compservice.findAllComPic();
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(comlist);
		return result;
	}


}
