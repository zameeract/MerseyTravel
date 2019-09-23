package HotlistReissue;




import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.excel.Excel_RenewalCode;
import com.test.hooks.Config;
import com.test.hooks.Hooks;

public class GenerateRenewalCode extends Hooks

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
	public void LoginGenerateRenewalCode() throws Exception
	{
	    //Loop to read multiple sets of Input data from Excel Sheet

		   for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
	     {
			   Excel_RenewalCode.read(i);
	           System.out.println("Excel Data loaded successfully");
	       //launch browser
	           launchBrowser();

	       //login
	           LoginIntoApplication();
	     
	
	       //scenario
				//Card Number
	           
	           driver.findElement(By.xpath("//input[@id='quicksearch']")).sendKeys(Excel_RenewalCode.Reference_CardNumber);
	           
	           driver.findElement(By.xpath("//input[@id='actionQuickSearch']")).click();
	           
	           
	           //Customer Result Table
	           try{
					driver.findElement(By.xpath("//caption[contains(text(),'Customer search results table')]")).isDisplayed(); 
					driver.findElement(By.xpath("//tbody[@class='clickable']")).click();
				}catch(Exception e)
	           {

						System.out.println("No Card Results : the erros is " + e);
	           }
	        
	         	                      
	           //Check "This card is Active"
	           try{
					driver.findElement(By.xpath("//div[@class='alertGreen']")).isDisplayed(); 
					
				}catch(Exception e)
	           {

						System.out.println("Card is not Active : the erros is " + e);
	           }
	           
	           // Generate Renewal code
	            
	      		try{
				if(Excel_RenewalCode.Generate_Renewal_Code.equals("N"))
				{
					System.out.println("No Renewal code");
					Thread.sleep(1000);
				}

				else {
					final Select RenewalCode = new Select(driver.findElement(By.name("templateId")));
					RenewalCode.selectByVisibleText(Excel_RenewalCode.Generate_Renewal_Code);
					
					System.out.println("Renewal code selected");
				}
	           
	           driver.findElement(By.xpath("//a[contains(text(),'Docs')]")).click();
	           driver.findElement(By.xpath("//a[@id='generateTemplate']")).click();
	                		
	      		Thread.sleep(3000);
		           driver.findElement(By.xpath("//input[@id='generateTemplate']")).click();	
		           
	     }
		           catch(final Exception e)
						{
							System.out.println(" Test Interrupted error at: " + e);
						}
	      		
	      		
	     }
	}
}
		   