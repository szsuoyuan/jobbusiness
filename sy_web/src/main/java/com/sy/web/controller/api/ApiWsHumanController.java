package com.sy.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.sy.commons.entity.HResult;
import com.sy.commons.utils.DateUtil;
import com.sy.commons.utils.FileCreate;
import com.sy.modules.common.GlobalConstants;
import com.sy.modules.entity.ws.WsHuman;
import com.sy.modules.exception.ApplicationException;
import com.sy.modules.service.ws.WsHumanService;
import com.sy.modules.utils.DataTool;
import com.sy.modules.utils.ImgUploadUtil;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;
/**
 * 会员相关接口
 * @author shishengbin
 *
 */
@Controller
@RequestMapping(value = "/api/wap")
public class ApiWsHumanController extends PageSet {
	private static final Logger log = LoggerFactory.getLogger(ApiWsHumanController.class);
	
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
			result.setCode(Constants.ERROR);
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
				result.setCode(Constants.SUCCESS);
				result.setValue(Constants.MSG_ADD_SUCCESS);
			}catch(Exception e) {
				result.setCode(Constants.ERROR);
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
			if(StringUtils.isNotBlank(smaccount)&&StringUtils.isNotBlank(smpass)){
				WsHuman human=humanService.humanLogin(smaccount, smpass);
				result.setCode(Constants.SUCCESS);
				result.setValue(Constants.MSG_LOGIN_SUCCESS);
				result.setObjValue(human);
			}
		} catch (ApplicationException e){
			result.setCode(Constants.ERROR);
			result.setResult(false);
			result.setValue(e.getMessage());
		}catch(Exception e){
			result.setCode(Constants.ERROR);
			result.setResult(false);
			result.setValue(e.getMessage());
		}
		log.info("---leaving---method---ApiController---doLogin---");
		return result;
	}
	
	//修改个人信息
	@RequestMapping(value = "/updateHuman")
	@ResponseBody
	public HResult<WsHuman> updatehuman(HttpServletRequest request,@ModelAttribute WsHuman human){
		HResult<WsHuman> result = new HResult<WsHuman>(false, "");
		int flag=-1;
		try{
			if(null != human){
				flag=humanService.updateHuman(human);
				if(flag>0){
					result.setCode(Constants.SUCCESS);
					result.setResult(true);
					result.setValue(Constants.MSG_UPDATE_SUCCESS);
					result.setObjValue(humanService.findHuman(human.getHumanId().intValue()));
				}
			}
		}catch(Exception e){
			result.setCode(Constants.ERROR);
			result.setResult(false);
			result.setValue(e.getMessage());
		}
		return result;
	}

	//查看个人信息
	@RequestMapping(value="/humanDetails")
	@ResponseBody
	public HResult<WsHuman> humanDetails(HttpServletRequest request,@RequestParam(value="humanId")Long humanId) {
		HResult<WsHuman> result = new HResult<WsHuman>(true, "");
		try{
			WsHuman human = humanService.findHuman(humanId.intValue());
			if(null != human){
				result.setCode(Constants.SUCCESS);
				result.setValue(Constants.MSG_GET_SUCCESS);
				result.setObjValue(human);
			}
		}catch(Exception e){
			result.setCode(Constants.ERROR);
			result.setResult(false);
			result.setValue(e.getMessage());
		}
		return result;
	}
	
	
	//上传会员头像
	@RequestMapping(value = "/uploadHumanPic")
	@ResponseBody
	public HResult<?> updatePersonHead(MultipartHttpServletRequest request,
			@RequestParam(value="humanId",required=true) Long humanId,
			@RequestParam(value="humanPicUrl") String humanPicUrl) throws IOException{
		log.info("---entering---method---ApiController---uploadHumanPic---picupload()---");
		HResult<WsHuman> result = new HResult<WsHuman>(true, "");
		WsHuman ws =null;
		if(null!=humanId){
			 ws = humanService.findHuman(humanId.intValue());
		}
		String fileNameSuffix = null;
		String fileName = null;
		//int width=Integer.parseInt(request.getParameter("width"));
		//int height=Integer.parseInt(request.getParameter("height"));
		// 项目在容器中实际发布运行的根路径
		//子文件夹
		String subFile=GlobalConstants.IMAGE_TEMP+GlobalConstants.SEPARATOR+humanId;
		System.out.println("---Temp path---"+subFile+"---");
		//生成唯一文件名
		//图片保存临时路径
		String savePath =subFile;
		//创建目录
		FileCreate.createDir(savePath);	
		//文件格式验证
		String picFormat=".jpg.png.gif.bmp";
		if (null != humanPicUrl && !"".equals(humanPicUrl)) {
			try {
				MultipartFile mf = request.getFile(humanPicUrl);
				fileName = mf.getOriginalFilename();
				String finalFilename=Constants.APPIMAGES+humanId+GlobalConstants.SEPARATOR+DateUtil.formatDate(new Date(), DateUtil.MM_DD_YYYY)+GlobalConstants.SEPARATOR+DataTool.getUUID()+fileName;
				if (null != mf && !"".equals(mf)) {
					fileNameSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
					fileNameSuffix=fileNameSuffix.toLowerCase();
					if(picFormat.contains(fileNameSuffix))
					{
						if(mf.getInputStream().available()<=300*1024)
						{
							//	BufferedImage bi=ImageIO.read(mf.getInputStream());
								String path=savePath+GlobalConstants.SEPARATOR+fileName;
								File file=new File(path);
								mf.transferTo(file);
								ImgUploadUtil.upload(path,finalFilename);
								file.delete();
								//返回状态，及文件名
								//out.write("{'state':'0','fileName':'" +GlobalConstants.DB_IMAGE_FILE+'/'+ finalFilename + "','updateP':'" + humanPicUrl+ "'}");
								ws.setHumanPicUrl(GlobalConstants.DB_IMAGE_FILE+'/'+ finalFilename);
								result.setCode(Constants.SUCCESS);
								result.setObjValue(ws);
							}
					}
					else{
						//out.write("{'state':'2'}");//图片大小超出
						result.setCode(Constants.ERROR);
						result.setResult(false);
					}
							
					}
					else
						result.setCode(Constants.ERROR);
						result.setResult(false);
				}catch (Exception e) {
					e.printStackTrace();
					result.setCode(Constants.ERROR);
					result.setResult(false);
				}
			} 
		log.info("---leaving---method---ApiController---uploadHumanPic---picupload()---");
		return result;
		}
		
}
