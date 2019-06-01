package com.generator;

import com.ssh.domain.Cat;

import lombok.Getter;

@Getter
public class ClassInfo {
	
		private String basePkg;//基础包名
		
		private String className;//domain类的简单名称

		public ClassInfo(Class<?> clz) {
			basePkg = clz.getPackage().getName().substring(0, clz.getPackage().getName().lastIndexOf("."));
			className = clz.getSimpleName();
			System.out.println(basePkg);
			System.out.println(className);
		}
	public static void main(String[] args) {
		new ClassInfo(Cat.class);
	}
		
}
