package com.sy.modules.taglib;

import org.apache.commons.lang3.StringUtils;
import com.sy.modules.utils.HtmlUtil;

/**
 * <p>User: sss
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class Functions {

	public static String filterHtmlTags(String param) {
		String str = "";
		if (StringUtils.isNotBlank(param)) {
			str = HtmlUtil.delHTMLTag(param);
		}
		return str.toString();
	}

}

