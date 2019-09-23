package com.test.excel;



import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_RenewalCode 
{

    public static String Reference_CardNumber;
    public static String Generate_Renewal_Code;
    

    public static void read(final int RowNumber) throws Exception
    {
        final File f=new File("TestData/GenerateRenewalCode.xlsx");
        final FileInputStream fi= new FileInputStream(f);

        @SuppressWarnings("resource")
		final XSSFWorkbook wb=new XSSFWorkbook(fi);
        final XSSFSheet sheet=wb.getSheetAt(0);

        for(int i=RowNumber; i<=RowNumber;  i++)
        {
            try{
            System.out.println("Entered into loop");
            Reference_CardNumber = sheet.getRow(i).getCell(0).getStringCellValue();
            Generate_Renewal_Code =sheet.getRow(i).getCell(1).getStringCellValue();
           
            System.out.println("Entering Row -> "+ i +"");
            System.out.println("Row data " + Reference_CardNumber );

            }
            catch(final Exception e)
            {
                System.out.println("Excel data not reading :error is:  " + e);
            }
        }

    }

}


