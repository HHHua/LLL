﻿package com.lll.class02;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class Log {
	
	private final Class<?> clazz;
	private Logger logger;
	
	public Log(Class<?> clazz) {
		this.clazz = clazz;
		this.logger = LogManager.getLogger(this.clazz);
		//设置显示图片或者链接到reportng输出
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}
	 public void info(String message){
		 logger.info(clazz.getCanonicalName() + ": " + message);
		 //设置带样式的reportng输出
		 Reporter.log("<span style=\"color:#2A00FF\">【info】"+clazz.getCanonicalName() + ": " + message+"</span><br />");
	 }
	 public void debug(String message){
		 logger.debug(clazz.getCanonicalName() + ": " + message);
		 Reporter.log("<span style=\"color:#2A00FF\">【debug】"+clazz.getCanonicalName() + ": " + message+"</span><br />");
	 }
	 public void error(String message){
		 logger.error(clazz.getCanonicalName() + ": " + message);
		 Reporter.log("<span style=\"color:#FF0000\">【error】"+clazz.getCanonicalName() + ": " + message+"</span><br />");
	 }
	 public void trace(String message){
		 logger.trace(clazz.getCanonicalName() + ": " + message);
		 Reporter.log("【trace】"+clazz.getCanonicalName() + ": " + message);
	 }
	 public void warn(String message){
		 logger.warn(clazz.getCanonicalName() + ": " + message);
		 Reporter.log("【warn】"+clazz.getCanonicalName() + ": " + message);
	 }
	 public void fatal(String message){
		 logger.fatal(clazz.getCanonicalName() + ": " + message);
		 Reporter.log("【fatal】"+clazz.getCanonicalName() + ": " + message);
	 }
	 public void screenShotLog(String comm,File file){
		 int width = 350;
		 String absolute = "file:" + file.getAbsolutePath();
		 Reporter.log("< a target='_blank' href=\""  +absolute + "\">");
		 Reporter.log("img width=\"" + width + "\" src=\"" +absolute + "\" />     "+comm);
		 Reporter.log("</a><br />");
	 }
  }
