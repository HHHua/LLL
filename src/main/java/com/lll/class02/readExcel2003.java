package com.lll.class02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel2003 {
	private static final String EXCEL_XLS="xls";
	private static final String EXCEL_XLSX="xlsx";

	public static void main(String[] args) {
		//指定读取的excel
		File excelFile = new File("G:\\79.5\\students.xls");
		FileInputStream in=null;
		Workbook wb = null;
		try {
			//把excel文件读入内存
			in = new FileInputStream(excelFile);
			//判断excel是2003还是2007
			if(excelFile.getName().endsWith(EXCEL_XLS)){
				wb=new HSSFWorkbook(in);
			}
			else if(excelFile.getName().endsWith(EXCEL_XLSX)){
				wb=new XSSFWorkbook(in);
			}
			
			//读取第一个sheet
			Sheet sheet0=wb.getSheetAt(0);
			//读取第一行
			Row firstRow = sheet0.getRow(0);
			
			//总的行数和列数
			int coloumNum = sheet0.getRow(0).getPhysicalNumberOfCells();
			int rowNum=sheet0.getLastRowNum()+1;
			
			//获取类型：0是数值  1是字符串
			
			//循环读取
//			for(Row row:sheet0){
//				Cell cell0=row.getCell(0);
//				Cell cell1=row.getCell(1);
//				Cell cell2=row.getCell(2);
//				System.out.print("姓名："+cell0.getRichStringCellValue().getString());
//				System.out.print("，年龄："+cell1.getNumericCellValue());
//				System.out.print("，分数："+cell2.getNumericCellValue());
//				System.out.println();
//			}
			//循环读取
			for(int i=0;i<rowNum;i++){
				Row row = sheet0.getRow(i);
				for(int j=0;j<coloumNum;j++){
					Cell cell = row.getCell(j);
					System.out.print(cell+"  ");
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
