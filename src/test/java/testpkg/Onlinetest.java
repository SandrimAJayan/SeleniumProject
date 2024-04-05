package testpkg;

import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.Koovsp;
import utilities.Excelutils;

public class Onlinetest extends Baseclass {
	@Test
public void verifylogin() throws Exception
	
	{	
		Koovsp p1=new Koovsp(driver);
		
		String a="sandrima";
		String b="yadhukts@gmail.com";
		String c="tomatopotato14@"	;
		p1.register(a,b,c);
	String X1="C:\\Users\\SANDRIMA\\OneDrive\\Desktop\\Book5.xlsx ";
	             
	String Sheet ="Sheet1";
	
	int rowCount = Excelutils.getrowcount(X1, Sheet);
	
	for (int i=1;i<rowCount;i++)
	{	
	
		String UserName=Excelutils.getCellValue(X1,Sheet, i, 0);
		System.out.println("Username--"+UserName);
		String Pwd =Excelutils.getCellValue(X1,Sheet,i,1);
		System.out.println("password---"+Pwd);
		//passing usernme and password as parameter
		
		p1.setvalues(UserName, Pwd);
		
		//Submitting the data by clicking on login button
		
	//	postcondition();
		String expurl="https://allushairoil.in/";
		String actualurl=driver.getCurrentUrl();
		if(actualurl.equals(expurl))
		{
			System.out.println("pass");
			
		}
		
		else
		{
		System.out.println("fail");
			
		}
		}
	p1.refereshing();
	System.out.println("check1");
	p1.addtocart2();
	p1.checkout();
	}
}
