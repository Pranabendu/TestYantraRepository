package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Exm {

	public static void main(String[] args) {
//		String [] arr = {"bablu","lalu","janu","ola"};
//		String s1 = "";
//		for (int i = 0; i < arr.length; i++) {
//			s1 = arr[i];
//		}
//		System.out.println(s1);
		
		
		Workbook book = null;
		try {
			FileInputStream fin = new FileInputStream("./files/Book1.xlsx");
			book = WorkbookFactory.create(fin);
			Sheet sheet = book.getSheet("Sheet1");
			String data = sheet.getRow(0).getCell(0).toString();
			System.out.println(data);
		} catch (IOException e) {
			e.getMessage();
		}
		finally {
			try {
				book.close();
				Reporter.log("DB is closed",true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Test
	void calender() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DATE, -20);
//		System.out.println(cal.toString());
//		Date dt = cal.getTime();
//		System.out.println(dt.toString());
//		String date = sdf.format(dt);
//		System.out.println(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 4);
		Date date = cal.getTime();
		System.out.println(date);
		System.out.println(sdf.format(date));
	}

	

}
