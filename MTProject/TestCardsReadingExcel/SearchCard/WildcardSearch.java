package SearchCard;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.excel.Excel_Searchdata;
import com.test.hooks.Config;
import com.test.hooks.Hooks;


public class WildcardSearch extends Hooks 
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
     public void LoginAdvSearch() throws Exception
     {
         //Loop to read multiple sets of Input data from Excel Sheet

         for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
      {
        	 Excel_Searchdata.read(i);
             System.out.println("Excel Data loaded successfully");
             //launch browser
             launchBrowser();

             //login
             LoginIntoApplication();

             //scenario
              driver.findElement(By.xpath("//a[contains(text(),'Advanced search')]")).click();


              //  Surname
              driver.findElement(By.xpath("//input[@id='customerSurname']")).sendKeys(Excel_Searchdata.Surname);
              Thread.sleep( 2000 );



              //click on Search Button
              driver.findElement( By.xpath("//input[@id='actionSearch']")).click();
              Thread.sleep( 2000 );
             
      }

 }

}
