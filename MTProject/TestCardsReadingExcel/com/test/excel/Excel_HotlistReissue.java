/*
 *             Copyright 2019 Applied Card Technologies Ltd
 */

package com.test.excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


    public class Excel_HotlistReissue
    {

        public static String Reference_CardNumber;
        public static String CardReason;
        public static String Hotlist;
        public static String Reissue;
        public static String Generate_Renewal_Code;
		
      //  public static int nor;
       


        public static void read(final int RowNumber) throws Exception
        {
            final File f=new File("TestData/hotlistreissue.xlsx");
            final FileInputStream fi= new FileInputStream(f);

            final XSSFWorkbook wb=new XSSFWorkbook(fi);
            final XSSFSheet sheet=wb.getSheetAt(0);
           // public static int nor= sheet.getLastRowNum();
			for(int i=RowNumber; i<=RowNumber;  i++)
            {
                try{
                System.out.println("Entered into loop");
                Reference_CardNumber = sheet.getRow(i).getCell(0).getStringCellValue();
                CardReason =sheet.getRow(i).getCell(1).getStringCellValue();
                Hotlist =sheet.getRow(i).getCell(2).getStringCellValue();
                Reissue = sheet.getRow(i).getCell(3).getStringCellValue();
                Generate_Renewal_Code = sheet.getRow(i).getCell(3).getStringCellValue();

                System.out.println("Entering Row -> "+ i +"");
                System.out.println("Row data " + Reference_CardNumber  + CardReason + Hotlist  + Reissue  + Generate_Renewal_Code );

                }
                catch(final Exception e)
                {
                    System.out.println("Excel data not reading :error is:  " + e);
                }
            }

        }

    }


