package com.lll.class02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readProperties {

	public static void main(String[] args) throws Exception {
		//方式一
//		Properties p = new Properties();
//		p.load(new FileInputStream("config\\local.properties"));
//		
//		System.out.println(p.toString());
//		String url = p.getProperty("url");
//		System.out.println(url);
		
		//方式二 properties文件要放在代码的src/main/java路径中 
		//把properties文件读入内存
		InputStream in = readProperties.class.getClassLoader().getResourceAsStream("local.properties");
		//创建一个properties对象
		Properties p = new Properties();
		//把内存中的数据加载至p中
		p.load(in);
		
		System.out.println(p.toString());
		//使用getProperty()获取对应key的值
		String url = p.getProperty("url");
		System.out.println(url);
		in.close();
		
	}

}
