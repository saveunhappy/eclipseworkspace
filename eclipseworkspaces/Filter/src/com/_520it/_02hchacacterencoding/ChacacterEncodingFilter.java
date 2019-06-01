package com._520it._02hchacacterencoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//字符编码过滤器
public class ChacacterEncodingFilter implements Filter{
	private String encoding;
	private Boolean forceEncoding;
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
		this.forceEncoding = Boolean.valueOf(config.getInitParameter("force"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			//设置编码
			//1应用中没有编码并且我设置了编码
			//2应用中已经存在了编码，但还是要使用我自己定义的编码：强制使用
			if(hasLength(encoding)&&(req.getCharacterEncoding() == null||forceEncoding)) {
			req.setCharacterEncoding(encoding);
			}
			chain.doFilter(req, resp);
	}
	public boolean hasLength(String str) {
		return !"".equals(str.trim())&&str!=null;
	}
	public void destroy() {
		
	}

}
