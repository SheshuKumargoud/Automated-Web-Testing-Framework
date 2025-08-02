package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By searchBox = By.name("q");
    By searchButton = By.name("btnK");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).submit();
    }

    public String getTitle() {
        return driver.getTitle();
    } 
}
