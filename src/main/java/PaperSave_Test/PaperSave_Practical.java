package PaperSave_Test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaperSave_Practical {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://hvtest9stg.app.cloud.papersave.com/workflow");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("slpatelhvtest9stg");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc123$$$");
        driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
        //driver.findElement(By.xpath("//button[@id='addNewDocNavigationAppName']")).click();

        /*WebElement DbBill_drpdwn=driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.visibilityOfAllElements(DbBill_drpdwn));
        Select drpdwn=new Select(DbBill_drpdwn);
        drpdwn.selectByVisibleText("DB Bill");
        WebElement Keying_drpdwn=driver.findElement(By.xpath("//button[@id='workflowStateName']"));
        WebDriverWait wait1 = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.visibilityOfAllElements(Keying_drpdwn));
        Select drpdwn1=new Select(Keying_drpdwn);
        drpdwn1.selectByVisibleText("Keying");*/
        //driver.findElement(By.xpath("//span[@class='workflowtext']")).click();
        WebDriverWait wait = new WebDriverWait(driver,120);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid_1305554038_0_content_table']/tbody")));
        driver.findElement(By.xpath("//*[@id='ejMenuBar']/div[1]/div[1]/div[3]/div/a")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement db_Bill=driver.findElement(By.xpath("//a[contains(text(),'DB Bill')]"));
        js.executeScript("arguments[0].scrollIntoView();", db_Bill);
        db_Bill.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid_1305554038_1_content_table']/tbody")));
        driver.findElement(By.xpath("//button[@id='workflowStateName']")).click();
        WebElement Keying=driver.findElement(By.xpath("//li[@id='15824']"));

        js.executeScript("arguments[0].scrollIntoView();", Keying);
        Keying.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid_1305554038_2_content_table']/tbody/tr[2]")));
        driver.findElement(By.xpath("//table[@id='grid_1305554038_2_content_table']/tbody/tr[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footerActionPanel']/div[2]/div/div[2]/button")));
        WebElement KeyButton=driver.findElement(By.xpath("//*[@id='footerActionPanel']/div[2]/div/div[2]/button"));
        Actions a=new Actions(driver);
        a.moveToElement(KeyButton).build().perform();
        driver.findElement(By.xpath("//table[@id='grid_1305554038_2_content_table']/tbody/tr[2]/td[2]")).click();
        
        try {
            driver.findElement(By.xpath("//input[@id='MetaDataEditorcontrol43771']")).sendKeys("1234");

        }
        catch(Exception e)
        {
            driver.findElement(By.xpath("//button[contains(text(),'Dismiss')]")).click();
            driver.findElement(By.xpath("//input[@id='MetaDataEditorcontrol43771']")).sendKeys("1234");
        }
        try {
            driver.findElement(By.xpath("//input[@id='documentdialognavigationclose']")).click();

        }
        catch(Exception e)
        {
            driver.findElement(By.xpath("//button[contains(text(),'Dismiss')]")).click();
            driver.findElement(By.xpath("//input[@id='documentdialognavigationclose']")).click();
        }

        HashMap<String, String> IDTextValueStore = new HashMap<String, String>();
        String id_Value=driver.findElement(By.xpath("//table[@id='grid_1305554038_0_content_table']/tbody/tr[2]/td[3]")).getText();
        String id_Text=driver.findElement(By.xpath("String value=driver.findElement(By.xpath(\"//table[@id='grid_1305554038_0_content_table']/tbody/tr[2]/td[3]\")).getText();")).getText();
        IDTextValueStore.put(id_Text, id_Value );
        for(Entry<String, String> m : IDTextValueStore.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }
	}

}
