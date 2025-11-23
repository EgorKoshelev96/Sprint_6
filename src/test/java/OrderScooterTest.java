import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderScooterTest {
    private WebDriver driver;
    OrderPageScooterTest objOrderPageScooterTest = new OrderPageScooterTest(driver);
    AboutPageRent objAboutPageRent = new AboutPageRent(driver);
    @BeforeEach
    public void setUp() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        this.driver = new ChromeDriver();
        this.objOrderPageScooterTest  = new OrderPageScooterTest(driver);
        this.objAboutPageRent = new AboutPageRent(driver);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
       WebElement element = driver.findElement(By.xpath
               (".//button[contains(text(), 'Заказать') and @class = 'Button_Button__ra12g']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @ParameterizedTest
    @MethodSource("orderDataScooter")
    void sooterTest(String name, String surname, String address, String metro, String phone, String buttonType,boolean expectedResult
    ,String rentalPeriod,String color,String comment ) throws InterruptedException {
        objOrderPageScooterTest.fillingScooterFields(name,surname,address,metro,phone,buttonType);
        WebElement dateField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//input[@placeholder='* Когда привезти самокат']")));
        boolean actualResult = dateField.isDisplayed();
        assertEquals(expectedResult, actualResult);
        objAboutPageRent.aboutRent(rentalPeriod,color,comment);
        WebElement modalHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath(".//button[contains(text(), 'Посмотреть статус') and @class = 'Button_Button__ra12g Button_Middle__1CSJM']")));
        actualResult = modalHeader.isDisplayed();
        assertEquals(expectedResult, actualResult);





    }

    static Stream<Arguments> orderDataScooter() {
        return Stream.of(
                Arguments.of("Агдрей", "Белов", "ул.Московская,20", "Сокол", "+79992345632", "top", true,
                        "трое суток", "black", "Оставить у двери"),
                Arguments.of("Ирина", "Белова", "пр.Майская,15", "Тверская", "+79061556432", "bottom", true,
                       "сутки","gray", " ")
    );
}

}


