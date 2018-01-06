package com.sy.web.controller.oa;

import java.util.ArrayList;
import java.util.List;

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
import com.sy.modules.entity.ws.WsMtPicture;
import com.sy.modules.service.oa.OaCustomerService;
import com.sy.modules.service.ws.WsMtPictureService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;
import com.sy.web.commons.SessionUtil;

@Controller
@RequestMapping("/oa")
public class OaCustomerController {

	@Autowired
	private OaCustomerService customerservice;
	
	@Autowired
	private WsMtPictureService pictureservice;

	// find all customers by page
	@RequestMapping(value = "/findAllCustomersByPage", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllCustomersByPage(Model model,@ModelAttribute OaCustomerVo customVo, HttpServletRequest request) {
		/*SysUser user = SessionUtil.getLoginUser(request);
		if (null != user) {
			customVo.setSysUserId(user.getId().intValue());
		}*/
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
		
		String[] jobimages = request.getParameterValues("jobimage");
		List<WsMtPicture> jobimageList = new ArrayList<WsMtPicture>();
		if (null != jobimages) {
			for (String filename : jobimages) {
				if (filename != null &&filename.trim().length()>0) {
					String fileurl=filename;
					// 拆分图文封面路径，存DB
					WsMtPicture f = new WsMtPicture();
					f.setPictureUrl(fileurl);
					f.setPictureName(fileurl);
					f.setPictureType("job");
					jobimageList.add(f);
				}
			}
			customer.setJobpictures(jobimageList);
		}
		
		String[] fileNames = request.getParameterValues("filename");
		List<WsMtPicture> picList = new ArrayList<WsMtPicture>();
		// 加载所有图片
		if (null != fileNames) {
			for (String filename : fileNames) {
				if (filename != null &&filename.trim().length()>0) {
					String fileurl=filename;
					// 拆分图文封面路径，存DB
					//int dex = filename.indexOf(Constants.APPIMAGES);
					//String fileurl = filename.substring(dex+ Constants.APPIMAGES.length());
					WsMtPicture f = new WsMtPicture();
					f.setPictureUrl(fileurl);
					f.setPictureName(fileurl);
					f.setPictureType("zs");
					picList.add(f);
				}
			}
			customer.setPictures(picList);
		}
		
		String[] foodimages = request.getParameterValues("foodimage");
		List<WsMtPicture> foodimageList= new ArrayList<WsMtPicture>();
		if (null != foodimages) {
			for (String filename : foodimages) {
				if (filename != null &&filename.trim().length()>0) {
					String fileurl=filename;
					// 拆分图文封面路径，存DB
					WsMtPicture f = new WsMtPicture();
					f.setPictureUrl(fileurl);
					f.setPictureName(fileurl);
					f.setPictureType("hs");
					foodimageList.add(f);
				}
			}
			customer.setHspictures(foodimageList);
		}
		
		
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
			//查询图片信息
			List<WsMtPicture> jobimagelist= pictureservice.findAllPictureListManager(cid,"job");
			List<WsMtPicture> zsimagelist= pictureservice.findAllPictureListManager(cid,"zs");
			List<WsMtPicture> hsimagelist= pictureservice.findAllPictureListManager(cid,"hs");
			model.addAttribute("jobpiclist",jobimagelist);
			model.addAttribute("zsimagelist",zsimagelist);
			model.addAttribute("hsimagelist",hsimagelist);
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
			
			String[] jobimages = request.getParameterValues("jobimage");
			List<WsMtPicture> jobimageList = new ArrayList<WsMtPicture>();
			// 加载所有图片
			if (null != jobimages) {
				for (String filename : jobimages) {
					if (filename != null &&filename.trim().length()>0) {
						String fileurl=filename;
						// 拆分图文封面路径，存DB
						WsMtPicture f = new WsMtPicture();
						f.setPictureUrl(fileurl);
						f.setPictureName(fileurl);
						f.setPictureType("job");
						jobimageList.add(f);
					}
				}
				customer.setJobpictures(jobimageList);
			}
			
			
			String[] fileNames = request.getParameterValues("filename");
			List<WsMtPicture> picList = new ArrayList<WsMtPicture>();
			// 加载所有图片
			if (null != fileNames) {
				for (String filename : fileNames) {
					if (filename != null &&filename.trim().length()>0) {
						String fileurl=filename;
						// 拆分图文封面路径，存DB
						WsMtPicture f = new WsMtPicture();
						f.setPictureUrl(fileurl);
						f.setPictureName(fileurl);
						f.setPictureType("zs");
						picList.add(f);
					}
				}
				customer.setPictures(picList);
			}
			
			String[] hsimages = request.getParameterValues("foodimage");
			List<WsMtPicture> hsimageList = new ArrayList<WsMtPicture>();
			// 加载所有图片
			if (null != hsimages) {
				for (String filename : hsimages) {
					if (filename != null &&filename.trim().length()>0) {
						String fileurl=filename;
						// 拆分图文封面路径，存DB
						WsMtPicture f = new WsMtPicture();
						f.setPictureUrl(fileurl);
						f.setPictureName(fileurl);
						f.setPictureType("hs");
						hsimageList.add(f);
					}
				}
				customer.setHspictures(hsimageList);
			}
			
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
