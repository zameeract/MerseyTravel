package com.test.suite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.excel.Excel_Read;
import com.test.hooks.Config;
import com.test.hooks.Hooks;

public class RunnerTest extends Hooks
{
	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
		//launch browser
        //launchBrowser();

        //login
        //  LoginIntoApplication();
	}

	@Test
	public void Login() throws Exception
	{
	    //Loop to read multiple sets of Input data from Excel Sheet

		for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
		{
		try
		{
			Excel_Read.read(i);
			System.out.println("Excel Data loaded successfully");
			//launch browser
			  launchBrowser();

			//login
			  LoginIntoApplication();

			//scenario
			 driver.findElement(By.xpath("//div[@class='bottom']//a[@href='addnewcardholder'][contains(text(),'Add new customer')]")).click();

             final Select Title = new Select(driver.findElement(By.xpath("//select[@id='customerTitle']")));
             Title.selectByVisibleText(Excel_Read.Title);

             //  Surname
             driver.findElement(By.xpath("//input[@name='customerSurname']")).sendKeys(Excel_Read.Surname);

             // Forename
             driver.findElement(By.xpath("//input[@id='customerForename']")).sendKeys(Excel_Read.Forename);

             //Radio button
             final WebElement Male=driver.findElement( By.xpath("//span[1]//input[1]"));
             final WebElement Female=driver.findElement( By.xpath("//input[@value='F']"));

             if(Excel_Read.Gender.equalsIgnoreCase("Male"))
             {
            	 Male.click();
            	 System.out.println("Radio Button Male Selected");
             }
                 else if(Excel_Read.Gender.equalsIgnoreCase("Female"))
             {
            	 Female.click();
            	 System.out.println("Radio Button Female Selected");
             }
             else
             {
            	System.out.println("System is selected Unknown option by default");
             }

             //Date of birth
             driver.findElement(By.id("customerDob")).sendKeys(Excel_Read.DateOfBirth);

             //Address

             driver.findElement(By.xpath("//input[@id='locationAddress1']")).sendKeys(Excel_Read.AddressLine_1);
             driver.findElement(By.xpath("//input[@id='locationAddress2']")).sendKeys(Excel_Read.AddressLine_2);
             driver.findElement(By.xpath("//input[@id='locationAddrPostcode']")).sendKeys(Excel_Read.Postcode);
            

             // Issueauthority
             final Select Issueauthority = new Select(driver.findElement(By.id("locationCardIssuer")));
             Issueauthority.selectByVisibleText(Excel_Read.Issueauthority);
             try
             {
                 final Robot robot = new Robot();
                 robot.keyPress(KeyEvent.VK_ENTER);
             }
             catch (final AWTException e)
             {
                 e.printStackTrace();
             }
             Thread.sleep( 2000 );
             
             // Disability status-duration
             try{
                 if(Excel_Read.Disability_status.equals("N"))
                 {
                 System.out.println("No Disabilities");
                 Thread.sleep(1000);
                 }

                 else {
                       final Select Disabilitystatus = new Select(driver.findElement(By.id("customerDisability")));
               	    Disabilitystatus.selectByVisibleText(Excel_Read.Disability_status);
                       System.out.println("Disability status selected");
                       Thread.sleep(1000);

                       final Select Disabilityduration = new Select(driver.findElement(By.name("Disability duration")));
                       Disabilityduration.selectByVisibleText(Excel_Read.Disability_duration);
                       System.out.println("Disability duration selected");
                         }
                 }
                     catch(final Exception e)
                     {
                     System.out.println(" Test Interrupted error at: " + e);
                     }

          // Apprenticecard - checkbox
             if(Excel_Read.Issueauthority.equalsIgnoreCase("Walrus IA"))
             {
                 final WebElement element = driver.findElement(By.id("ApprenticeCard"));
                 if (element.isDisplayed() && element.isEnabled())
                 {
                     element.click();
                 }
                 System.out.println("ApprenticeCard check box is selected");
             }

           //staff indicator - checkbox
              if(Excel_Read.Issueauthority.equalsIgnoreCase("Merseytravel HR"))
             {
                  final WebElement staffindicator = driver.findElement( By.id("StaffIndicator"));
                   if (staffindicator.isDisplayed() && staffindicator.isEnabled())
                   {
                       staffindicator.click();
                   }
                   System.out.println("Staff Indicator check box is selected");

                 //Staff number -text
                 driver.findElement(By.id("StaffNumber")).sendKeys(Excel_Read.Staff_number);

                 //Staff pass type - dropdown
                 final Select Staffpasstype = new Select(driver.findElement(By.name("StaffPassType")));
                 Staffpasstype.selectByVisibleText(Excel_Read.Staff_pass_type);

                 //Staff job title - text
                 driver.findElement(By.id("StaffJobTitle")).sendKeys(Excel_Read.Staff_job_title);

             }
             else
             {
               }

             

             //click Add Button
                  driver.findElement( By.xpath("//input[@id='customerAdd']")).click();

              //upload photo image
                  driver.findElement(By.xpath("//input[@id='photoImage']")).click();

                  final WebElement UploadImg = driver.findElement(By.xpath("//input[@id='photoImage']"));
                  UploadImg.sendKeys("D:\\Tulips.jpg");

                  driver.findElement(By.xpath("//input[@id='actionUpload']")).click();
                  driver.findElement(By.xpath("//img[@id='Accept']")).click();

             // Prints text and closes alert
                 final Robot rb=new Robot();

                 rb.keyPress( KeyEvent.VK_CANCEL);
                 rb.keyRelease( KeyEvent.VK_CANCEL);

                 Thread.sleep(2000);
             //Print location
                 driver.findElement(By.xpath("//a[contains(text(),'Cards')]")).click();

             //Cardtype - dropdown
                 final Select CardType = new Select(driver.findElement(By.name("cardType")));
                 CardType.selectByVisibleText(Excel_Read.CardType);

                 final Select select = new Select(driver.findElement(By.xpath("//select[@id='printingLocation']")));
                 select.selectByVisibleText("Unicard Local Printing (Mann Island)");

                  //driver.findElement(By.xpath("//select[@name='printingLocation']")).click();
                 // driver.findElement(By.xpath("//option[@value='61']")).click();



                 //IssueCard
                 driver.findElement(By.xpath("//input[@value='Issue card']")).click();



                 //CompleteCard
                 driver.findElement(By.xpath("//input[@value='Complete Card Creation']")).click();
                Thread.sleep(3000);

                 driver.findElement(By.xpath("//li[@id='tab4']//a[@href='#'][contains(text(),'Audit')]")).click();

                 System.out.println("Test Ended");

                 Pass_Count = Pass_Count+1;

			//Hooks.EndTest();

		    } catch (final Exception e)
		        {
		        Fail_Count = Fail_Count+1;
		        }
		    }
		        System.out.println("Pass Count ->" + Pass_Count);
		        System.out.println("Fail Count ->" + Fail_Count);
	    }


	    @AfterTest
	    public void CloseTest() throws Exception
	        {
	    	System.out.println("TEST COMPLETED");
	        }
        }
