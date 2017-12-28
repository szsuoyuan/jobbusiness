package com.sy.web.controller.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

import sun.misc.BASE64Decoder;

import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sy.commons.entity.HResult;
import com.sy.commons.utils.DateUtil;
import com.sy.commons.utils.FileCreate;
import com.sy.commons.utils.FileDirectoryCopyUtil;
import com.sy.modules.common.GlobalConstants;
import com.sy.modules.entity.ws.WsHuman;
import com.sy.modules.exception.ApplicationException;
import com.sy.modules.service.ws.WsHumanService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;
import com.sy.web.commons.PictureUtil;
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
					result.setValue(Constants.MSG_LOGIN_SUCCESS);
					result.setObjValue(human);
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
	public Map<String,String> updatePersonHead(HttpServletRequest request,
			@RequestParam(value="humanId",required=true) Long humanId,@RequestParam(value="humanPicUrl") String humanPicUrl) throws IOException{
		if(humanId==null){
			humanId=0L;
		}
		WsHuman ws = humanService.findHuman(humanId.intValue());
		Map<String,String> rmap = new HashMap<String,String>();
		if(ws==null||ws.getHumanId()==null){
			return rmap;
		}
		byte[] pbyte = new BASE64Decoder().decodeBuffer(humanPicUrl);  
		for (int i = 0; i < pbyte.length; ++i) {  
	        if (pbyte[i] < 0) {  
	            // 调整异常数据  
	            pbyte[i] += 256;  
	        }  
	    }
		InputStream input = new ByteArrayInputStream(pbyte);
		//七牛云
		Auth auth = Auth.create(GlobalConstants.ACCESS_KEY, GlobalConstants.SECRET_KEY);//密匙配置
		UploadManager upload = new UploadManager();//创建上传对象
		//创建头像的文件名
		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMddHHmmsss");
		String filename=simpleFormat.format(new Date())+ new Random().nextInt(1000);
		String realPath=request.getSession().getServletContext().getRealPath("/");
		log.info("---项目路径：----"+realPath+"---");
		//创建保存头像的文件
		//D:\\ndb_file\\picture\\
	    String savePath =realPath+GlobalConstants.IMAGE_TEMP+humanId+GlobalConstants.SEPARATOR+DateUtil.formatDate(new Date(), DateUtil.MM_DD_YYYY);
	    FileCreate.createDir(savePath);
	    //保存头像到指定的文件夹内
	    PictureUtil.SaveFileFromInputStream(input, savePath,filename+".jpg");
	    //保存到数据库中的头像路径
	    String dbpath=ws.getHumanAccount()+"/"+DateUtil.formatDate(new Date(), DateUtil.MM_DD_YYYY)+GlobalConstants.SEPARATOR+filename;
	    //调用put方法上传
	    upload.put(savePath+GlobalConstants.SEPARATOR+filename+".jpg",dbpath, auth.uploadToken(GlobalConstants.BUCKET_NAME));
	    //删除创建的临时目录
	    FileDirectoryCopyUtil.del(savePath);					         
	    ws.setHumanPicUrl(dbpath);
	    ws.setUpdateName(humanId+"");
	    humanService.updateHuman(ws);
		rmap.put("humanId", ws.getHumanId()+"");
		//rmap.put("human_nickname", ws.getHuman_nickname()!=null?ws.getHuman_nickname().trim():"");
		if(null!=ws.getHumanPicUrl()&& ws.getHumanPicUrl().trim().length()>0){
			rmap.put("humanPicUrl", GlobalConstants.DB_IMAGE_FILE+ws.getHumanPicUrl().trim());
		}else{
			rmap.put("humanPicUrl", "");
		}
		//rmap.put("human_signature", ws.getHuman_signature()!=null?ws.getHuman_signature().trim():"");
		//rmap.put("human_sex", ws.getHuman_sex()!=null?ws.getHuman_sex().trim():"");
		return rmap;
	}
	
}
