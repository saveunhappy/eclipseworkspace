package com._520it._core.web;

import java.util.HashMap;
import java.util.Map;

import com._520it.ResultConfig;

//封装了<action>元素中的所有信息
public class ActionConfig {
	private String name;//<action>元素的name属性
	private String className;//<action>元素的class属性
	private String method;//<action>元素的method属性
	public ActionConfig(String name, String className, String method) {
		this.name = name;
		this.className = className;
		this.method = method;
	}
	public Map<String, ResultConfig> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, ResultConfig> resultMap) {
		this.resultMap = resultMap;
	}
	private Map<String,ResultConfig> resultMap = new HashMap<>();

	
	public String toString() {
		return "ActionConfig [className=" + className + ", method=" + method + ", resultMap=" + resultMap + "]";
	}
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	public String getMethod() {
		return method;
	}
	
	
}
 