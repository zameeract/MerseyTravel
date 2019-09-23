package com.test.excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {

	public static String Title;
	public static String Surname;
	public static String Forename;
	public static String Gender;
	public static String DateOfBirth;
	public static String AddressLine_1;
	public static String AddressLine_2;
	public static String Postcode;
	public static String Issueauthority;
	public static String Disability_status;
	public static String Disability_duration;
	public static String Apprentice_card;
	public static String Staff_indicator;
	public static String Staff_number;
	public static String Staff_pass_type;
	public static String Staff_job_title;
	public static String CardType;


	public static void read(final int RowNumber) throws Exception
	{
		final File f=new File("TestData/Merseytraveltestdata.xlsx");
		final FileInputStream fi= new FileInputStream(f);

		@SuppressWarnings("resource")
		final XSSFWorkbook wb=new XSSFWorkbook(fi);
		final XSSFSheet sheet=wb.getSheetAt(0);

		for(int i=RowNumber; i<=RowNumber;  i++)
		{
			try{
			System.out.println("Entered into loop");
			Title = sheet.getRow(i).getCell(0).getStringCellValue();
			Surname =sheet.getRow(i).getCell(1).getStringCellValue();
			Forename =sheet.getRow(i).getCell(2).getStringCellValue();
			Gender = sheet.getRow(i).getCell(3).getStringCellValue();
			DateOfBirth =sheet.getRow(i).getCell(4).getStringCellValue();
			AddressLine_1 =sheet.getRow(i).getCell(5).getStringCellValue();
			AddressLine_2 = sheet.getRow(i).getCell(6).getStringCellValue();
			Postcode = sheet.getRow(i).getCell(7).getStringCellValue();
			Issueauthority =sheet.getRow(i).getCell(8).getStringCellValue();
			Disability_status =sheet.getRow(i).getCell(9).getStringCellValue();
			Disability_duration = sheet.getRow(i).getCell(10).getStringCellValue();
			Apprentice_card =sheet.getRow(i).getCell(11).getStringCellValue();
			Staff_indicator =sheet.getRow(i).getCell(12).getStringCellValue();
			Staff_number =sheet.getRow(i).getCell(13).getStringCellValue();
			Staff_pass_type = sheet.getRow(i).getCell(14).getStringCellValue();
			Staff_job_title = sheet.getRow(i).getCell(15).getStringCellValue();
			CardType = sheet.getRow(i).getCell(16).getStringCellValue();

			System.out.println("Entering Row -> "+ i +"");
			System.out.println("Row data " + Title  + Surname + Gender  + DateOfBirth + Issueauthority +Disability_status + Apprentice_card + Staff_number + Staff_job_title + CardType);

			}
			catch(final Exception e)
			{
				System.out.println("Excel data not reading :error is:  " + e);
			}
		}

	}

}
