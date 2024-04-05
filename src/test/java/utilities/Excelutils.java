package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	public static String getCellValue(String X1,String x2,int r,int c) {
		try
		{//
			FileInputStream fi=new FileInputStream(X1);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFCell cell =wb.getSheet(x2).getRow(r).getCell(c);
			
			if(cell.getCellType()==CellType.STRING)
			{
				
				return cell.getStringCellValue();
				
			}
			else
			{
				//  double v=cell.getNumericCellValue();
				//  int val=(int)v;
				//return String.valueOf(val);
	
				return cell.getRawValue();
				
			}
			
			
		}catch (Exception e)
		{
			return "";
		}
		
	}
		public static int getrowcount(String X1,String Sheet) throws IOException 
		{
		try
		{
			//File f=new File(X1);
			
			FileInputStream fi=new FileInputStream(X1);
			XSSFWorkbook wb= new XSSFWorkbook(fi);
			return wb.getSheet(Sheet).getLastRowNum();
			
		}
		catch (Exception e)
		{
			return 0;
		}
		}
	}



