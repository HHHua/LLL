package com.lll.class02;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class readXml {

	public static void main(String[] args) throws DocumentException {
		//读取工具
		SAXReader saxReader = new SAXReader();
		//指定读取文件
		Document document = saxReader.read("D:\\java work\\LLL\\data\\students.xml");
		//获取根节点
		Element root = document.getRootElement();
		
		//提取所有数据
		List<Element> childList = root.elements();
		for(Element el:childList){
			System.out.println("元素名称："+el.getName());
			System.out.println("姓名："+el.attributeValue("name"));
			System.out.println("年龄："+el.attributeValue("age"));
			System.out.println("学号："+el.getText());
			System.out.println("----------------------------");
		}
	}

}
