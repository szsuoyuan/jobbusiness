package com.sy.web.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sy.modules.common.GlobalConstants;
import com.sy.modules.entity.sys.SysComPicture;
import com.sy.modules.service.sys.SysComPictureService;
import com.sy.web.commons.PageSet;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;

@Controller
@RequestMapping(value = "/sys")
public class ComPictureController extends PageSet {
	private static final Logger log = LoggerFactory.getLogger(ComPictureController.class);

	@Autowired
	private SysComPictureService compservice;

	// 预添加
	@RequestMapping(value = "/preaddpic", method = { RequestMethod.GET, RequestMethod.POST })
	public String precreateemp() {
		return "sys/addcompic";
	}

	/**
	 * 添加轮播图片
	 */
	@RequestMapping(value = "/addComPic")
	@ResponseBody
	public String addComPic(HttpServletRequest request,@ModelAttribute SysComPicture compic) {
		log.info("entering...ComPictureController...addComPic()");
		//String flag = request.getParameter("flag");
		SysComPicture compicture = null;
		String picname = request.getParameter("picname");
		String filename = request.getParameter("filename");
		if (StringUtils.isNotEmpty(filename)) {
			compicture = new SysComPicture();
			// 拆分图文封面路径，存DB
			int dex = filename.indexOf(Constants.APPIMAGES);
			String fileurl = filename.substring(dex + Constants.APPIMAGES.length());
			compicture.setPicurl(fileurl);
			compicture.setPicname(picname);
		}
		/*if (flag.equals("add")) {
			compservice.create(compicture);
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_ADD_SUCCESS, Constants.REL_SYSPICMANAGER, null,
					Constants.CLOSECURRENT, "sys/findComPicByPage");
		} else if (flag.equals("upd")) {
			String str = request.getParameter("id");
			if (StringUtils.isNotEmpty(str)) {
				long picid = Long.valueOf(str);
				compicture.setId(picid);
			}
			compservice.update(compicture);
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_UPDATE_SUCCESS, Constants.REL_SYSPICMANAGER, null,
					Constants.CLOSECURRENT, "sys/findComPicByPage");
		}*/
		if (null != compic.getId()) {
			String str = request.getParameter("id");
			if (StringUtils.isNotEmpty(str)) {
				long picid = Long.valueOf(str);
				compicture.setId(picid);
			}
			compservice.update(compicture);
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_UPDATE_SUCCESS, Constants.REL_SYSPICMANAGER, null,Constants.CLOSECURRENT, "sys/findComPicByPage");
		} else{
			compservice.create(compicture);
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_ADD_SUCCESS, Constants.REL_SYSPICMANAGER, null,Constants.CLOSECURRENT, "sys/findComPicByPage");
		}
	}

	/**
	 * 删除轮播图片
	 */
	@RequestMapping(value = "delComPic")
	@ResponseBody
	public String delComPic(HttpServletRequest request) {
		log.info("entering...ComPictureController...delComPic()");
		String str = request.getParameter("id");
		if (StringUtils.isNotEmpty(str)) {
			long compicid = Long.valueOf(str);
			compservice.delete(compicid);
			return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_DEL_SUCCESS, Constants.REL_SYSPICMANAGER, null, null,
					null);
		}
		return JsonUtil.transferJsonResponse(Constants.SUCCESS, Constants.MSG_DEL_FAIL, Constants.REL_SYSPICMANAGER, null, null, null);
	}

	/**
	 * 根据i的查询单个信息
	 */
	@RequestMapping(value = "/findComPicById")
	public String findComPicById(HttpServletRequest request) {
		SysComPicture comp = null;
		String str = request.getParameter("id");
		if (StringUtils.isNotEmpty(str)) {
			long compicid = Long.valueOf(str);
			comp = compservice.findById(compicid);
		}
		request.setAttribute("comp", comp);
		//request.setAttribute("picurl", Constants.DB_IMAGE_FILE + "/" + comp.getPicurl());
		request.setAttribute("picurl", GlobalConstants.DB_IMAGE_FILE+GlobalConstants.SEPARATOR+Constants.APPIMAGES + comp.getPicurl());
		
		return "sys/addcompic";
	}

	/**
	 * 分页查询微官网首页轮播图
	 */

	@RequestMapping(value = "/findComPicByPage")
	public String findComPicByPage(HttpServletRequest request) {
		log.info("entering...ComPictureController...findComPicByPage()");
		// 图片名称
		String picName = request.getParameter("picname");
		Map<String, Object> map = new HashMap<String, Object>();
		this.setPagination(request, map);
		map.put("picname", picName);
		List<SysComPicture> complist = compservice.findAllComPicByPage(map);
		// 总数
		long totalNum = compservice.findCountByParam(map);
		request.setAttribute("complist", complist);
		request.setAttribute("totalCount", totalNum);
		request.setAttribute("picname", picName);
		return "sys/compicmanager";
	}

	
}
