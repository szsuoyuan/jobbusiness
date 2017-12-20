package com.sy.web.controller.ws;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageInfo;
import com.sy.modules.entity.vo.ws.WsRecordVo;
import com.sy.modules.entity.ws.WsRecord;
import com.sy.modules.service.ws.WsRecordService;

@Controller
@RequestMapping("/ws")
public class WsRecordController {
	
	@Autowired
	private WsRecordService recordservice;
	
	//查询所有打卡记录
		@RequestMapping(value = "/findAllRecords", method = { RequestMethod.GET,RequestMethod.POST })
		public String findAllRecords(Model model,@ModelAttribute WsRecordVo  recordVo, HttpServletRequest request) {
			//SysUser user=SessionUtil.getLoginUser(request);
			PageInfo<WsRecord> recordList= recordservice.findAllWsRecordByPage(recordVo);
			model.addAttribute("recordList", recordList);
			return "ws/record/recordlist";
		}

}
