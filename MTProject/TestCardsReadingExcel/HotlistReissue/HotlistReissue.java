package HotlistReissue;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.test.excel.Excel_HotlistReissue;

import com.test.hooks.Config;
import com.test.hooks.Hooks;

public class HotlistReissue extends Hooks
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
	public void LoginHotlistReissue() throws Exception
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
             
             driver.findElement(By.xpath("//tbody[@class='clickable']")).click();
             driver.findElement(By.xpath("//a[contains(text(),'Cards')]")).click();
             
        /*     //Check "This card is Active"
             
             try{
					driver.findElement(By.xpath("//div[@class='alertGreen']")).isDisplayed(); 
					
				}catch(Exception e)
             		{

						System.out.println("Card is not Active : the erros is " + e);
             		}
           */             
             //CardReason
             try{
                 if(Excel_HotlistReissue.CardReason.equals("N"))
                 {
                 System.out.println("Do Not Issue");
                 Thread.sleep(1000);
                 }

                 else {Thread.sleep(1000);
                       final Select CardReason = new Select(driver.findElement(By.xpath("//*[contains(@id,'cardReason')]")));
                                     
                       CardReason.selectByVisibleText(Excel_HotlistReissue.CardReason);
                       System.out.println("CardReason selected");
                       Thread.sleep(1000);
                 } 
                 
                    //Hotlist
                                              
                       try{

                    	   if(Excel_HotlistReissue.Hotlist.equals("Y"))
                    	   {
                    		   driver.findElement(By.xpath("//*[contains(@id,'cardHotlist')]")).click();
                    	   }
                    	   else
                    	   {
                    		   System.out.println("hot list sets as No");
                    	   }

                    	   
                   //Re-issue
                    	   if(Excel_HotlistReissue.Reissue.equals("Y"))
                    	   {
                    		   driver.findElement(By.xpath("//*[contains(@id,'cardReissue')]")).click();
                    	   }
                    	   else
                    	   {
                    		   System.out.println("re-issue or hotlist not applicable");
                    	   }

                       }catch(Exception e)
                       {
                    	   System.out.println("Issue at clicking hotlist/ re issue, the error is :" + e);
                       }
                      }
                 
                     catch(final Exception e)
                     {
                     System.out.println(" Test Interrupted error at: " + e);
                     }
             
                 
                               
	    }
	}
}
          
 