package com.lll.class02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logDemo {
	private static Logger logger = LogManager.getLogger(logDemo.class.getName());
	public static void main(String[] args) {
		logger.fatal("fatal:系统已死机");
		logger.error("error:系统错误");
		logger.warn("warn:warn消息");
		logger.info("info:info消息");
		logger.debug("debug:debug消息");

	}

}
