package SearchCard;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.excel.Excel_HotlistReissue;
import com.test.hooks.Config;
import com.test.hooks.Hooks;


public class Search extends Hooks
{
	
	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
		//launch browser
        //launchBrowser();

        //login
        //LoginIntoApplication();
	}

	@Test
	public void LoginSearch() throws Exception
	{
	    //Loop to read multiple sets of Input data from Excel Sheet

		   for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
	     {
			   Excel_HotlistReissue.read(i);
	           System.out.println("Excel Data loaded successfully");
	       //launch browser
	           launchBrowser();

	       //login
	           LoginIntoApplication();

	       //scenario
	         
	      //Card Number
	         driver.findElement(By.xpath("//input[@id='quicksearch']")).sendKeys(Excel_HotlistReissue.Reference_CardNumber);
	                           
             driver.findElement(By.xpath("//input[@id='actionQuickSearch']")).click();
                                    
             //Check "This card is Active"
             
             
             try{
					driver.findElement(By.xpath("//caption[contains(text(),'Customer search results table')]")).isDisplayed(); 
					
				}catch(Exception e)
{

						System.out.println("No Card Data : the erros is " + e);
}
                        
             driver.findElement(By.xpath("//tbody[@class='clickable']")).click();
             //driver.findElement(By.xpath("//a[contains(text(),'Cards')]")).click();
             
	     }
     
	     
	}
}