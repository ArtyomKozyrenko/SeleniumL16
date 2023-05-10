import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SeleniumTest {

    private final static By CALCULATE_BUTTON_BASE_PAGE = By.xpath("//span[text()='Розрахувати']");
    private final static By CALCULATE_BUTTON_CALCULATE_PAGE = By.xpath("//app-form-submit/div");
    private final static By COOKIE_PANEL_AGREE_BUTTON = By.xpath("//input[@value='Погоджуюсь']");
    private final static By THANK_YOU_POP_UP_BUTTON = By.xpath("//button[text()='Дякую, ознайомлений (-а)']");
    private final static By FROM_DROPDOWN = By.xpath("//input[@id=\"fromWhere\"]");
    private final static By TO_DROPDOWN = By.xpath("//input[@id=\"toWhere\"]");
    private final static By FIRST_OPTION_TAB = By.xpath("//form-select[1]//ul//button[1]");
    private final static By SECOND_OPTION_TAB = By.xpath("//form-select[2]//ul//button[1]");
    private final static By WEIGHT_FIELD = By.cssSelector("input[placeholder='кг']");
    private final static By SIDE_FIELD = By.cssSelector("input[placeholder='см']");


    @Test
    public void method() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ukrposhta.ua/ua");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(COOKIE_PANEL_AGREE_BUTTON).click();
        driver.findElement(CALCULATE_BUTTON_BASE_PAGE).click();
        Thread.sleep(4000);
        driver.findElement(THANK_YOU_POP_UP_BUTTON).click();
        assertFalse(driver.findElement(CALCULATE_BUTTON_CALCULATE_PAGE).isDisplayed());

        driver.findElement(FROM_DROPDOWN).sendKeys("Харків");
        Thread.sleep(4000);
        driver.findElement(FIRST_OPTION_TAB).click();

        driver.findElement(TO_DROPDOWN).sendKeys("Харків");
        Thread.sleep(4000);
        driver.findElement(SECOND_OPTION_TAB).click();
        driver.findElement(WEIGHT_FIELD).sendKeys("20");
        driver.findElement(WEIGHT_FIELD).sendKeys(Keys.ENTER);
        driver.findElement(SIDE_FIELD).sendKeys("20");
        driver.findElement(SIDE_FIELD).sendKeys(Keys.ENTER);

        assertTrue(driver.findElement(CALCULATE_BUTTON_CALCULATE_PAGE).isDisplayed());
        assertTrue(driver.findElement(CALCULATE_BUTTON_CALCULATE_PAGE).isEnabled());

    }

}
