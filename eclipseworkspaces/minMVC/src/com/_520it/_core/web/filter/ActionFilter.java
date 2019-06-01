package com._520it._core.web.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com._520it.ResultConfig;
import com._520it._core.web.ActionConfig;
import com._520it._core.web.ActionContext;

//前端控制器
public class ActionFilter implements Filter{
	 //key用来存储<action>元素中的name属性
	 //value用来存储<action>元素的封装类：ActionConfig对象
	private Map<String,ActionConfig> actionConfigMap = new HashMap<>();
	public void init(FilterConfig filterConfig) throws ServletException {
		Document doc = this.getDocument();
		//获取actions.xml文件中的<action>元素，每一个action元素都应该封装成一个ActionConfig对象
		NodeList nodeList = doc.getElementsByTagName("action");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element actionEl = (Element) nodeList.item(i);//每一个action元素
			String name = actionEl.getAttribute("name");
			String className = actionEl.getAttribute("class");
			String method = actionEl.getAttribute("method");
			ActionConfig actionConfig = new ActionConfig(name, className, method);
			actionConfigMap.put(name, actionConfig);
			//--------------------------------------
			//读取action元素中的result元素并额封装成对象
			NodeList resultNodeList = actionEl.getElementsByTagName("result");
			for (int j = 0; j < resultNodeList.getLength(); j++) {
				Element resultEl = (Element) resultNodeList.item(j);
				String resultName = resultEl.getAttribute("name");
				String type = resultEl.getAttribute("type");
				String path = resultEl.getTextContent();
				ResultConfig resultConfig = new ResultConfig(resultName, type, path);
				actionConfig.getResultMap().put(name, resultConfig);
				
			}
		}
		System.out.println(actionConfigMap);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//------------------------------------
		ActionContext ctx = new ActionContext(req, resp);
		ActionContext.setContext(ctx);
		//------------------------------------
		
		//获取请求的资源名称
		String requestUri = req.getRequestURI().substring(1);
//		if("employee".equals(requestUri)) {
//			EmployeeAction action = new EmployeeAction();
//			action.execute();
//		}else if("department".equals(requestUri)) {
//			DepartmentAction action2 = new DepartmentAction();
//			action2.execute();
//		}
		ActionConfig actionConfig = actionConfigMap.get(requestUri);
		if(actionConfig == null) {
			chain.doFilter(req, resp);
		}
		try {
		String className = actionConfig.getClassName();//Action中的全限定名
		String method1 = actionConfig.getMethod();//Action中，处理请求的方法
		Class actionClass = Class.forName(className);
		Object actionObject = actionClass.newInstance();
		Method method = actionClass.getMethod(method1);//获得请求的方法对象
		//使用反射调用方法
		Object ret = method.invoke(actionObject);
		if(ret!=null) {
			String viewName = ret.toString();
			//根据逻辑视图名取出对应的action对象
			ResultConfig config = actionConfig.getResultMap().get(viewName);
			if(config!=null) {
				String type=config.getType();
				String path=config.getPath();
				if("dispatcher".equals(type)) {
					req.getRequestDispatcher(path).forward(req, resp);
				}else if("redirect".equals(type)) {
					//防止跳出当前应用
					resp.sendRedirect(req.getContextPath()+path);
				}
			}
		}
		}catch(Exception e){
			e.getMessage();
		}
	}
	private Document getDocument() {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("actions.xml");
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void destroy() {
		
	}

}
