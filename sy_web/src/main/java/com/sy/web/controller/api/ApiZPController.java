package com.sy.web.controller.api;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.sy.commons.entity.HResult;
import com.sy.modules.entity.oa.OaCustomer;
import com.sy.modules.entity.vo.oa.OaCustomerVo;
import com.sy.modules.entity.ws.WsMtPicture;
import com.sy.modules.service.oa.OaCustomerService;
import com.sy.modules.service.ws.WsMtPictureService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;

@Controller
@RequestMapping(value = "/api/wap")
public class ApiZPController extends PageSet {
	
	@Autowired
	private OaCustomerService customerService;
	
	@Autowired
	private WsMtPictureService pictureService;
	
	private static final Logger log = LoggerFactory.getLogger(ApiZPController.class);
	//今日招工列表
	@RequestMapping(value = "/searchCompanyAndJobInfo")
	@ResponseBody
	public HResult<PageInfo<OaCustomer>> searchCompanyAndJobInfo(HttpServletRequest request,Model model,@ModelAttribute OaCustomerVo customVo){
		log.info("---entering---method---searchCompanyAndJobInfo()---");
		HResult<PageInfo<OaCustomer>> result = new HResult<>(true, "");
		PageInfo<OaCustomer> customlist = customerService.findAllCustomersByPage(customVo);
		result.setCode(Constants.SUCCESS);
		result.setObjValue(customlist);
		log.info("---leaving---method---searchCompanyAndJobInfo()---");
	return result;
	}
	
	//招工详情
	@RequestMapping(value = "/searchCompanyAndJobInfoById")
	@ResponseBody
	public HResult<OaCustomer> searchCompanyAndJobInfoById(HttpServletRequest request,Model model,@RequestParam(value="cId") Integer cId){
		HResult<OaCustomer> result = new HResult<>(true, "");
		if(null != cId){
			OaCustomer customer = customerService.findCustomer(cId);
			List<WsMtPicture> pictureList =	pictureService.findAllPictureListManager(cId,"job");
			if(null != pictureList){
				customer.setJobpictures(pictureList);
				result.setCode(Constants.SUCCESS);
				result.setObjValue(customer);
			}
		}
		return result;
	}
	
	//临时工

}
