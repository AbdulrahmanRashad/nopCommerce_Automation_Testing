
import Pages.HomePage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class OpenWebsite {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goToHomePage(){
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
    @DataProvider
    public Object [] [] logInData () {
        Object [][] data = new Object [3][2];

        data [0][0] = "TestNG@Framework.com";		data [0][1] = "TestNG1234";
        data [1][0] = "Joe@Doe.com";			    data [1][1] = "DoeDoe34";
        data [2][0] = "Test@AutomationU.com";		data [2][1] = "TAU1234";

        return data;
    }
    @DataProvider
    public static Object[][] ReadVariant() throws IOException {

        String excelPath = "H:\\ITI\\Projects\\nopCommerce\\nopCommerce\\src\\main\\resources\\TestData\\TestData.xlsx";

        DataFormatter formatter = new DataFormatter();

        FileInputStream fileInputStream= new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow Row = worksheet.getRow(0);

        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum = Row.getLastCellNum();// get last ColNum

        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

        for(int i=0; i<RowNum-1; i++) //Loop work for Rows
        {
            XSSFRow row= worksheet.getRow(i+1);
            for (int j=0; j<ColNum; j++) //Loop work for colNum
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    Cell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it gets Null value it pass no data
                    else
                    {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
            }
        }
        return Data;
    }
}
