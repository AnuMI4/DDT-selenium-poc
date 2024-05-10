package DDTWithJUnit;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Run this class with some parameters
@RunWith(value = Parameterized.class)
public class RunWithDDT {
    WebDriver driver = new ChromeDriver();
    String name;
    String email;
    String address;

    @Before
    public void setUp () {
        driver.get("https://demoqa.com/text-box");
    }

    @After
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void addData () {
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        driver.findElement(By.id("userName")).sendKeys(name);
    }
    // This annotated method is designed to pass parameters into the class via constructor
    @Parameters
    public static List<String[]> getData () throws IOException, CsvException {
        FileReader filereader = new FileReader("data.csv");
        CSVReader csvReader = new CSVReader(filereader);
        //System.out.println(csvReader.readAll());
        List<String[]> allData = csvReader.readAll();
        return allData;
    }

    //constructor to pass values to the test method
    public RunWithDDT (String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

}
