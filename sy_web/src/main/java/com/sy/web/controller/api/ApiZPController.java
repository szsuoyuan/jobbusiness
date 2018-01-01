package com.sy.web.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sy.web.commons.PageSet;

@Controller
@RequestMapping(value = "/api/wap")
public class ApiZPController extends PageSet {
	
	private static final Logger log = LoggerFactory.getLogger(ApiZPController.class);

}
