package com.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

import com.ssh.domain.Cat;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

//代码生成器
public class CodeGenertator {
	
	private static Configuration config;
	static {
		try {
			config = new Configuration(Configuration.VERSION_2_3_22);
			config.setDirectoryForTemplateLoading(new File("templates"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
	/*	Template template = config.getTemplate("IDAO.java");*/
		ClassInfo classinfo = new ClassInfo(Cat.class);
		//String path= "src/com/ssh/dao/"+"ICatDAO.java";
/*		//设置{0}和{1}的值
		String filepath = MessageFormat.format(path, classinfo.getBasePkg().replace(".", "/"),classinfo.getClassName());
		template.process(classinfo, new FileWriter(filepath));*/
		//createFile(classinfo, "IDAO.java", "src/{0}/dao/"+"I{1}DAO.java");
		createFile(classinfo, "DAOImpl.java", "src/{0}/dao/impl/"+"{1}DAOImpl.java");
	}
	
	private static void createFile(ClassInfo classinfo,String templateName,String path) throws Exception{
		Template template = config.getTemplate(templateName);
		
		String filepath = MessageFormat.format(path, classinfo.getBasePkg().replace(".", "/"),classinfo.getClassName());
		template.process(classinfo, new FileWriter(filepath));
	}
}	
