package com.sy.web.controller.ws;

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
import com.sy.commons.utils.DataTool;
import com.sy.modules.entity.vo.ws.WsOrderVo;
import com.sy.modules.entity.ws.WsOrder;
import com.sy.modules.service.ws.WsOrderService;
import com.sy.web.commons.Constants;
import com.sy.web.commons.JsonUtil;

@Controller
@RequestMapping("/ws")
public class WsOrderController {

	@Autowired
	private WsOrderService orderService;

	// find all orders by page
	@RequestMapping(value = "/findAllWsOrdersByPage", method = {RequestMethod.GET, RequestMethod.POST })
	public String findAllWsOrdersByPage(Model model,@ModelAttribute WsOrderVo orderVo, HttpServletRequest request) {
		PageInfo<WsOrder> orderList = orderService.findAllWsOrdersByPage(orderVo);
		model.addAttribute("orderList", orderList);
		return "ws/order/orderlist";
	}
	
	// prepare add
		@RequestMapping(value = "/preaddorder", method = { RequestMethod.GET,RequestMethod.POST })
		public String preaddorder(Model model,HttpServletRequest request) {
			model.addAttribute("oNumber", DataTool.createCoding());
			return "ws/order/addorder";
		}
		
	// save order info
	@RequestMapping(value = "/saveOrder", method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String saveOrder(Model model, HttpServletRequest request,@ModelAttribute WsOrder order) {
		String oUserName=request.getParameter("user.userName");
		String oEmpId=request.getParameter("user.id");
		int flag = -1;
		if (null != order) {
			if(StringUtils.isNotBlank(oUserName)){
				order.setoUsername(oUserName);
			}
			if(StringUtils.isNotBlank(oEmpId)){
				order.setoEmpId(Integer.parseInt(oEmpId));
			}
			flag = orderService.saveWsOrder(order);
		}
		if (flag > 0) {
			return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_ADD_SUCCESS, Constants.REL_ORDERMANAGER,null, Constants.CLOSECURRENT, "ws/findAllWsOrdersByPage");
		} else {
			return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_ADD_FAIL, null, null, null, null);
		}
	}
	
	// delete order
		@RequestMapping(value = "/{oId}/deleteOrder")
		@ResponseBody
		public String deleteOrder(@PathVariable("oId") Integer oId,HttpServletRequest request) {
			int flag = -1;
			if (null != oId && oId > 0) {
				WsOrder order=new WsOrder();
				order.setoId(oId);
				flag = orderService.deleteWsOrder(order);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_DEL_SUCCESS, Constants.REL_ORDERMANAGER,null, null, null);
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_DEL_FAIL, Constants.REL_ORDERMANAGER,null, null, null);
			}
		}
		//find order by id
		@RequestMapping(value = "/findOrderById/{oId}")
		public String findOrderById(@PathVariable("oId") Integer oId,Model model, HttpServletRequest request) {
			if (null != oId) {
				WsOrder order = orderService.findWsOrder(oId);
				model.addAttribute("order", order);
			}
			return "ws/order/preupdorder";
		}

		// update customer
		@RequestMapping(value = "/saveOrderByUpd")
		@ResponseBody
		public String saveOrderByUpd(Model model,@ModelAttribute WsOrder order, HttpServletRequest request) {
			int flag = -1;
			if (null != order) {
				flag = orderService.updateWsOrder(order);
			}
			if (flag > 0) {
				return JsonUtil.transferJsonResponse(Constants.SUCCESS,Constants.MSG_UPDATE_SUCCESS, Constants.REL_ORDERMANAGER,null, Constants.CLOSECURRENT, "ws/findAllWsOrdersByPage");
			} else {
				return JsonUtil.transferJsonResponse(Constants.ERROR,Constants.MSG_UPDATE_FAIL, null, null, null, null);
			}
		}
		

}
