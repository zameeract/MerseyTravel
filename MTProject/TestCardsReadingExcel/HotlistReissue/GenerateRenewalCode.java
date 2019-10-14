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
	        
	         	                      
	      // Generate Renewal code
	           
	           driver.findElement(By.xpath("//a[contains(text(),'Docs')]")).click();
	           Thread.sleep(5000);
	           
	           driver.findElement(By.xpath("//a[@id='generateTemplate']")).click();
	           
	          try{
				
	        	  if(Excel_RenewalCode.Generate_Renewal_Code.equals("N"))			       			
				{
					System.out.println("No Renewal code");
					
				}

				else {
					final Select RenewalCode = new Select(driver.findElement(By.xpath("//select[@id='templateId']")));
					RenewalCode.selectByVisibleText(Excel_RenewalCode.Generate_Renewal_Code);
					Thread.sleep(5000);
					
					driver.findElement(By.xpath("//input[@id='generateTemplate']")).click();
					
			     	System.out.println("Renewal code selected");
				}
				  
	              
		    	     }
		           catch(final Exception e)
						{
							System.out.println(" Test Interrupted error at: " + e);
						}
	     }
	}
}
		   