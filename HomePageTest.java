package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import utils.DBUtils;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void verifySearch() {
        homePage.search("Selenium WebDriver");
        Assert.assertTrue(homePage.getTitle().contains("Selenium WebDriver"));
    }

    @Test(priority = 2)
    public void backendUserValidation() {
        boolean exists = DBUtils.checkUserExists("sheshu123");
        Assert.assertTrue(exists, "User should exist in DB");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
