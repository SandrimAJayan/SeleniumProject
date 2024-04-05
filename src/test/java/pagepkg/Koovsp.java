package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Koovsp {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[1]/header/div/section[2]/div/div[2]/div/section[2]/div/div[2]/div/div/div/div/nav/ul/li[2]/a")
	WebElement acnt; 
	@FindBy(xpath="/html/body/div[2]/header/div/section[2]/div/div[2]/div/section[2]/div/div[2]/div/div/div/div/nav/ul/li[1]/a")
	WebElement Loreg;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[1]/input")
	WebElement username;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[2]/input")
	WebElement email;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[3]/span/input")
	WebElement pswd;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[4]/button")
	WebElement regbutton;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[1]/form/p[1]/input")
	WebElement lemail2;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[1]/form/p[2]/span/input")
	WebElement lpswd2;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div[2]/div[1]/form/p[3]/button")
	WebElement login;
	@FindBy(xpath="/html/body/div[2]/header/div/section[2]/div/div[2]/div/section[2]/div/div[1]/div/div/div/div/nav/ul/li[1]/a")
	WebElement home;
	@FindBy(xpath="/html/body/div[2]/header/div/section[2]/div/div[2]/div/section[1]/div/div[3]/div/div/div/div/div/div/a/div/span")
	WebElement cart;
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/main/div/div[2]/div[2]/form/div/div[2]/button")
	public WebElement addcart;
	@FindBy(xpath="/html/body/div[1]/header/div/section[2]/div/div[2]/div/section[2]/div/div[1]/div/div/div/div/nav/ul/li[3]/a")
	public WebElement shop;
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/main/div/div[2]/div[2]/form/table/tbody/tr/td/select")
	WebElement dropml;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/nav/ul/li[6]/a")
	WebElement logout1;
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/main/article/div/div/div/p[1]/a")
	WebElement logout2;
	@FindBy(xpath="	/html/body/div[1]/div/div/div[2]/main/article/div/div/nav/ul/li[1]/a")
	public WebElement dash;
	 public Koovsp(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	public void register(String x1,String x2,String x3)
	{
		Loreg.click();
		username.sendKeys(x1);
		email.sendKeys(x2);
		pswd.sendKeys(x3);
		regbutton.click();	
		
	}
	
	public void setvalues(String x5,String x6)
	{
		lemail2.clear();
		lemail2.sendKeys(x5);
		lpswd2.clear();
		lpswd2.sendKeys(x6);
		login.click();
	}
         	
	public void refereshing()
	{
		driver.navigate().refresh();
	}
	
	public void alerthandling()
	{
		ChromeOptions options =new ChromeOptions();
		options.addArguments("---disable-notifications");
		}
 
	public void addtocart()
	{
		System.out.println("check2");
		shop.click();
		List<WebElement> products=driver.findElements(By.className("astra-shop-summary-wrap"));
		int s=products.size();
		System.out.println(s);
		for(WebElement current:products)
		{
			String y=current.getText()	;
			System.out.println(y);
			current.click();
			Select qty=new Select(dropml);
			qty.selectByIndex(1);
			addcart.click();
			driver.navigate().back();
		}
	}
	public void addtocart2() {
		shop.click();
		String z1="/html/body/div[1]/div/div/div[1]/main/div/ul/li[";
		String z2="]/div[1]/a/img";
		for(int i=1;i<=8;i++) {
			String Z=z1+i+z2;
			driver.findElement(By.xpath(Z)).click();
			Select qty=new Select(dropml);
			qty.selectByIndex(1);
			addcart.click();
			driver.navigate().back();
			
		}
		
	}
	public void checkout()
	{	driver.findElement(By.xpath("/html/body/div[1]/header/div/section[2]/div/div[2]/div/section[1]/div/div[3]/div/div/div/div/div/div/a/div/span")).click();
		acnt.click();
	logout2.click();
	}
}
