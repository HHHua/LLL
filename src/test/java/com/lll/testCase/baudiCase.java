package com.lll.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lll.class01.BaiDuTest;
import com.lll.class02.Log;
import org.testng.Reporter;
public class baudiCase {
	private static Log log=new Log(baudiCase.class);
	WebDriver driver =null;
	//数据分离：测试数据（数据驱动、xml文件parameter配置、excel）
	@DataProvider(name="testData")
	public static Object[][] primeNumbers(){
		return new Object[][]{{"12306","12306_百度搜索"},{"新梦想","新梦想_百度搜索"},{"软件测试","软件测试_百度搜索"}};
	}
	
	@BeforeMethod
	@Parameters("url")
	public void setUp(String url){
		driver = BaiDuTest.openWeb(driver, url);
		//使用自封装的Log类打印日志
//		log.info("前置方法执行完成");
		//使用reportng打印日志
		Reporter.log("<span style=\"color:#16A05D\"><H2>前置方法执行完成</H2>");
	}
	
	@Test(dataProvider="testData")
	public void test01(String search,String expected) {
		driver = BaiDuTest.search(driver, search, expected);
//		log.info("用例执行结束");
		Reporter.log("<span style=\"color:#16A05D\"><H2>用例执行结束</H2>");

  }

	@AfterMethod
	public void quit(){
		BaiDuTest.logOut(driver);
//		log.info("后置方法执行完成");
		Reporter.log("<span style=\"color:#16A05D\"><H2>后置方法执行完成</H2>");

  }
}
