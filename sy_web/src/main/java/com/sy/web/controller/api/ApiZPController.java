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
import com.sy.modules.entity.oa.OaLinkman;
import com.sy.modules.entity.oa.OaRecord;
import com.sy.modules.entity.vo.oa.OaCustomerVo;
import com.sy.modules.entity.vo.oa.OaRecordVo;
import com.sy.modules.entity.ws.WsMtPicture;
import com.sy.modules.service.oa.OaCustomerService;
import com.sy.modules.service.oa.OaLinkmanService;
import com.sy.modules.service.oa.OaRecordService;
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
	
	@Autowired
	private OaLinkmanService linkmanservice;
	
	@Autowired
	private OaRecordService recordservice;
	
	private static final Logger log = LoggerFactory.getLogger(ApiZPController.class);
	//今日招工列表
	@RequestMapping(value = "/searchCompanyAndJobInfo")
	@ResponseBody
	public HResult<PageInfo<OaCustomer>> searchCompanyAndJobInfo(HttpServletRequest request,Model model,@ModelAttribute OaCustomerVo customVo,
			@RequestParam(value="jobType") Integer jobType){
		log.info("---entering---method---searchCompanyAndJobInfo()---");
		HResult<PageInfo<OaCustomer>> result = new HResult<>(true, "");
		PageInfo<OaCustomer> customlist=null;
		if(null !=jobType && jobType==1){
			 customlist = customerService.findAllCustomersByPage(customVo);
		}
		if(null !=jobType && jobType==2){
			 customlist = customerService.findAllLSCustomersByPage(customVo);
		}
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
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
			List<WsMtPicture> zsimagelist= pictureService.findAllPictureListManager(cId,"zs");
			List<WsMtPicture> hsimagelist= pictureService.findAllPictureListManager(cId,"hs");
			if(null != pictureList){
				customer.setJobpictures(pictureList);
			}
			if(null != zsimagelist){
				customer.setPictures(zsimagelist);
			}
			if(null != hsimagelist){
				customer.setHspictures(hsimagelist);
			}
			OaLinkman linkman=	linkmanservice.findLinkman(cId);
			customer.setLinkman(linkman);
			result.setCode(Constants.SUCCESS);
			result.setValue(Constants.MSG_GET_SUCCESS);
			result.setObjValue(customer);
		}
		return result;
	}
	
	//临时工
	@RequestMapping(value = "/searchLSCompanyAndJobInfo")
	@ResponseBody
	public HResult<PageInfo<OaRecord>> searchLSCompanyAndJobInfo(HttpServletRequest request,Model model,@ModelAttribute OaRecordVo recordVo){
		log.info("---entering---method---searchLSCompanyAndJobInfo()---");
		HResult<PageInfo<OaRecord>> result = new HResult<>(true, "");
		PageInfo<OaRecord> recordlist = recordservice.findAllRecordsByPage(recordVo);
		result.setCode(Constants.SUCCESS);
		result.setValue(Constants.MSG_GET_SUCCESS);
		result.setObjValue(recordlist);
		log.info("---leaving---method---searchLSCompanyAndJobInfo()---");
		return result;
	}
	

}
