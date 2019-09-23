package com.test.suite;

import org.testng.annotations.*;

import com.test.excel.Excel_Read;
import com.test.hooks.Config;
import com.test.hooks.Hooks;

public class TestExcelData extends Hooks
{

	@BeforeTest
	public void launchApplication() throws Exception
	{
		System.out.println("TEST STARTED");
	}
	
	
	@Test
	public void Login() throws Exception
	{ 
		/**
		 * @@ Writing for loop to read multiple sets of 
		 *    Input data from Excel Sheet
		 **/
		for(int i=Config.Start_Row_Number; i<=Config.End_Row_Number;i++)
		{
			
		try 
		{
			System.out.println("This test is just testing excel data is loading or not");
			Excel_Read.read(i);
			
		}catch (Exception e) 
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
