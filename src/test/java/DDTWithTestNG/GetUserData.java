package DDTWithTestNG;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class GetUserData {
    WebDriver driver;

    @BeforeMethod
    public void setUp () {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void LoginTest (String name, String email, String password) {
        System.out.println(name + "hello");
        driver.findElement(By.id("userName")).sendKeys(name);
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

   @DataProvider
    public String[][] getData () throws IOException {
        String[][] accumulateData = new String[4][3];
        FileInputStream file = new FileInputStream(new File("UserLogin.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int i = 0;

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            int j = 0;
            Row row = rowIterator.next();

            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                accumulateData[i][j] = cell.getStringCellValue();
                j += 1;
            }
            System.out.println("");
            i += 1;
        }
        file.close();
        return accumulateData;
    }
}
