package xmlDemo;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Demo1 {
	private File f = new File("D:\\eclipse工作区间\\XML\\src\\xmlDemo\\contains.xml");

	@Test
	public void testName() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f);

	}

	@Test
	public void test1() throws Exception {
		// 1:获取Document文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2:获取XML中的根元素
		Element root = doc.getDocumentElement();
		// 3:获取第二个联系人元素(linkman)
		Element linkmanEl = (Element) root.getElementsByTagName("linkman").item(1);
		// 4:获取linkman元素下的name元素
		Element nameEl = (Element) linkmanEl.getElementsByTagName("name").item(0);
		System.out.println(nameEl.getTextContent());

	}

	@Test
	public void test2() throws Exception {
		// 1:获取Document文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2:获取XML中的根元素
		Element root = doc.getDocumentElement();
		// 3:获取第一个联系人元素(linkman)
		Element linkmanEl = (Element) root.getElementsByTagName("linkman").item(0);
		// 4:获取linkman元素下的email元素
		Element emailEl = (Element) linkmanEl.getElementsByTagName("email").item(0);
		// 5:设置email元素的新的文本内容(will@)
		emailEl.setTextContent("will@");
		// 6:同步操作:Transformer
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);// 源：内存中的document对象
		Result outputTarget = new StreamResult(f);// 目标：磁盘中的XML文件(contains.xml)
		trans.transform(xmlSource, outputTarget);

	}

	@Test
	public void test3() throws Exception {
		// 1:获取Document文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2:获取XML中的根元素
		Element root = doc.getDocumentElement();
		// 3:创建一个linkman元素的片段
		// 3.1创建linkman，email,name,address,group元素
		Element linkmanEl = doc.createElement("linkman");
		Element emailEl = doc.createElement("email");
		Element nameEl = doc.createElement("name");
		Element addressEl = doc.createElement("address");
		Element groupEl = doc.createElement("group");
		// 3.2给name,email,address,group元素设置文本内容
		nameEl.setTextContent("Luck");
		emailEl.setTextContent("Lucy@");
		addressEl.setTextContent("北京");
		groupEl.setTextContent("嘎嘎");
		// 3.3把name,email,address,group设置为linkman的子元素
		linkmanEl.appendChild(nameEl);
		linkmanEl.appendChild(emailEl);
		linkmanEl.appendChild(addressEl);
		linkmanEl.appendChild(groupEl);
		// 3.4把linkman元素作为根元素的子元素
		root.appendChild(linkmanEl);
		// 6:同步操作:Transformer
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);// 源：内存中的document对象
		Result outputTarget = new StreamResult(f);// 目标：磁盘中的XML文件(contains.xml)
		trans.transform(xmlSource, outputTarget);

	}

	@Test
	public void test4() throws Exception {
		// 1:获取Document文档对象
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		// 2:获取XML中的根元素
		Element root = doc.getDocumentElement();
		// 3:获取第一个联系人元素(linkman)
		Element linkmanEl = (Element) root.getElementsByTagName("linkman").item(2);
		/**
		 * 设置属性
		 */
		linkmanEl.setAttribute("id", "123");
		/**
		 * 获得属性
		 */
		String id = linkmanEl.getAttribute("id");
		System.out.println(id);
		/**
		 * 请自己的老爸来干掉自己
		 */
		linkmanEl.getParentNode().removeChild(linkmanEl);
		// 6:同步操作:Transformer
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		Source xmlSource = new DOMSource(doc);// 源：内存中的document对象
		Result outputTarget = new StreamResult(f);// 目标：磁盘中的XML文件(contains.xml)
		trans.transform(xmlSource, outputTarget);

	}
	@Test
	public void test5() throws Exception {
		SAXReader reader = new SAXReader();
		org.dom4j.Document doc = reader.read(f);
		org.dom4j.Element root = doc.getRootElement();
		org.dom4j.Element linkmanList = root.element("linkman");
		for (iterable_type iterable_element : iterable) {
			ArrayList
		}

	}
	
	

}
