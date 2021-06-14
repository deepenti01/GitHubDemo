package sampleTest;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IdeasTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<WebElement> dropdowns = new ArrayList<WebElement>();
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://wanikirtesh.github.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement details=driver.findElement(By.xpath("//Select[@id='selDetails']"));
		Select s=new Select(details);
		System.out.println(details.getText());
		s.selectByVisibleText("department");
		s.selectByVisibleText("region");
		WebElement fltrDept = driver.findElement(By.xpath("//*[@id='fltdepartment']"));
		WebElement fltrRegion = driver.findElement(By.xpath("//*[@id='fltregion']"));
		dropdowns.add(fltrDept);
		dropdowns.add(fltrRegion);
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfAllElements(dropdowns));
		fltrDept.click();
		Select ss=new Select(fltrDept);
		ss.selectByVisibleText("Marketing");
		fltrRegion.click();
		Select sss=new Select(fltrRegion);
		sss.selectByVisibleText("UAE");
		driver.findElement(By.id("btnGen")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parent = driver.getWindowHandle();
		Set<String> Allwindows= driver.getWindowHandles();
		for(String a: Allwindows)
		{
			if(!a.equalsIgnoreCase(parent))
			{
				driver.switchTo().window(a);
			}
		}
		
		WebElement table = driver.findElement(By.xpath("//table[@id='rpt']"));
		WebElement tableBody = table.findElement(By.tagName("tbody"));
		List<WebElement> e = tableBody.findElements(By.tagName("tr"));
		assertTrue(e.size() == 9);
		String[] ExpectedRecord = {"4","Chetan Patel","Marketing","UAE","band 2","5",""};
		List<WebElement> rowdata = e.get(3).findElements(By.tagName("td"));
		int i=0;
		for(WebElement r :rowdata)
		{
			assertTrue(r.getText().equalsIgnoreCase(ExpectedRecord[i]));
			if(i==6)
			{
				assertTrue(r.findElement(By.tagName("input")).getAttribute("checked").equalsIgnoreCase("true"));
			}
			i++;
		}
		i = 0;
		for(WebElement temp: e)
		{
			List<WebElement> rows = temp.findElements(By.tagName("td"));
			if(rows.get(6).findElement(By.tagName("input")).getAttribute("checked").)
			{
				i++;
			}
		}
		assertTrue("Total Check records are not matching",i == 4);
		driver.quit();
	}

}
