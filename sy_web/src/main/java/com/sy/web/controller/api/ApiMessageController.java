package com.sy.web.controller.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.sy.commons.entity.HResult;
import com.sy.commons.utils.DateUtil;
import com.sy.commons.utils.FileCreate;
import com.sy.commons.utils.FileDirectoryCopyUtil;
import com.sy.modules.common.GlobalConstants;
import com.sy.modules.entity.ws.WsMessages;
import com.sy.modules.entity.ws.WsMessagesUser;
import com.sy.modules.service.ws.WsMessagesService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.PageSet;
import com.sy.web.commons.PictureUtil;

@Controller
@RequestMapping(value = "/api/wap")
public class ApiMessageController extends PageSet {
	
	private static final Logger log = LoggerFactory.getLogger(ApiMessageController.class);
	@Autowired 
	private WsMessagesService messageservice;
	
	@RequestMapping(value="/searchAllMessages")
	@ResponseBody
	public String searchAllMessages(HttpServletRequest request,HttpServletResponse response){
		log.info("entering...ApiMessageController...findAllMessagesByPage()...");
		long humanId=-1;
		String humanIdStr=request.getParameter("humanId");
		Map<String,Object> map = new HashMap<String,Object>();
		this.setPagination(request, map);
		if(StringUtils.isNotBlank(humanIdStr)){
			humanId=Long.parseLong(humanIdStr);
		}
		//获取用户ID
		map.put("humanId",humanId);
		List<WsMessages> messages = messageservice.findAllMessagesByPage(map);
		Gson gson=new Gson();
		return gson.toJson(messages);
	}
	
	
	@RequestMapping(value="/addMessages")
	@ResponseBody
	public HResult<WsMessages>  addMessages(HttpServletResponse response,HttpServletRequest request){
		HResult<WsMessages> result = new HResult<WsMessages>(true, "");
		long humanId=-1;
		String humanIdStr=request.getParameter("humanId");
		if(StringUtils.isNotBlank(humanIdStr)){
			humanId=Long.valueOf(humanIdStr);
		}
		String humanName=request.getParameter("humanAccount");
		String title=request.getParameter("title");//标题
		String content=request.getParameter("content");//内容
		String picurl=request.getParameter("humanPicUrl");//图片
		WsMessagesUser wmu = new WsMessagesUser();
		//wmu.setUserId(id);
		wmu.setHumanId(humanId);
		WsMessages wm=new WsMessages();
		if(StringUtils.isNotBlank(title)){
			wm.setMessageTitle(title);
		}
		if(StringUtils.isNotBlank(content)){
			wm.setMessageContent(content);
		}
		if(StringUtils.isNotBlank(picurl)){
			wm.setMessageEmail(picurl);
		}
		if(StringUtils.isNotBlank(humanName)){
			wm.setCreateName(humanName);
		}
		try{
			boolean success = messageservice.addMessages(wm, wmu);
			if(success){
				result.setCode(Constants.SUCCESS);
				result.setValue(Constants.MSG_ADD_SUCCESS);
			}else{
				result.setCode(Constants.ERROR);
				result.setResult(false);
			}
		}catch(Exception e){
			result.setCode(Constants.ERROR);
			result.setResult(false);
			result.setValue(e.getMessage());
		}
		return result;
	}
	
		//上传提问图片
		@RequestMapping(value = "/uploadMessagePic")
		@ResponseBody
		public HResult<WsMessages> uploadMessagePic(HttpServletRequest request,
				@RequestParam(value="humanPicUrl") String humanPicUrl) throws IOException{
			log.info("---entering---method---ApiMessageController---uploadHumanPic---picupload()---");
			Map<String, Object> map=new HashMap<>();
			HResult<WsMessages> result = new HResult<WsMessages>(true, "");
			try
			{
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
				//创建保存头像的文件
			    String savePath = GlobalConstants.IMAGE_TEMP_LINUX+GlobalConstants.SEPARATOR+GlobalConstants.SEPARATOR+DateUtil.formatDate(new Date(), DateUtil.MM_DD_YYYY);
			    FileCreate.createDir(savePath);
			    //保存头像到指定的文件夹内
				PictureUtil.SaveFileFromInputStream(input, savePath, filename +".jpg");
			    //保存到数据库中的头像路径
			    String dbpath=GlobalConstants.SEPARATOR+DateUtil.formatDate(new Date(), DateUtil.MM_DD_YYYY)+GlobalConstants.SEPARATOR+filename;
			    //调用put方法上传
			    upload.put(savePath+GlobalConstants.SEPARATOR+filename+".jpg",dbpath, auth.uploadToken(GlobalConstants.BUCKET_NAME));
			    FileDirectoryCopyUtil.del(GlobalConstants.IMAGE_TEMP_LINUX);				
				
			    map.put("humanPicUrl", GlobalConstants.DB_IMAGE_FILE+GlobalConstants.SEPARATOR+dbpath);
			    result.setCode(Constants.SUCCESS);
				result.setValue(Constants.MSG_GET_SUCCESS);
				result.setParamMap(map);
				
			}catch(Exception e){
				map.put("humanPicUrl", "");
				result.setCode(Constants.ERROR);
				result.setResult(false);
			}
			log.info("---leaving---method---ApiMessageController---uploadHumanPic---picupload()---");
			return result;
		}

}
