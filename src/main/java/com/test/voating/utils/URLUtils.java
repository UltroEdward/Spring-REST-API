package com.test.voating.utils;

import javax.servlet.http.HttpServletRequest;

public class URLUtils {

    public static String getBaseUrl(HttpServletRequest request) {
	StringBuffer url = request.getRequestURL();
	String uri = request.getRequestURI();
	String ctx = request.getContextPath();
	return url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
    }

}
