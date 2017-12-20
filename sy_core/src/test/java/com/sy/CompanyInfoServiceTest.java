package com.sy;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sy.modules.entity.sys.CompanyInfo;
import com.sy.modules.service.sys.CompanyInfoService;

public class CompanyInfoServiceTest extends BaseSpringTestCase {

	@Autowired
	private CompanyInfoService cifservice;
	
	@Test
	public void findCompanyInfoTest()
	{
		CompanyInfo cf= cifservice.findCompanyInfo(1L);
		System.out.println(cf.getCompanyname());

	}
}
