package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
	static FileInputStream fis1;
	
public static HashMap<String, String> getData(String testdata)
{
	
	try {
		new FileInputStream("src\\test\\resources\\testdata\\excels");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		XSSFWorkbook wb=new XSSFWorkbook(fis1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

}
