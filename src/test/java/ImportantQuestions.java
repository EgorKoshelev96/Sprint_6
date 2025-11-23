import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class ImportantQuestions {
    private WebDriver driver;
    ImportantPageQuestions objImportantQuestions = new ImportantPageQuestions(driver);


    @BeforeEach
    public void setUp() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        this.driver = new ChromeDriver();
        this.objImportantQuestions = new ImportantPageQuestions(driver);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_FAQ__3uVm4")));
        WebElement element = driver.findElement(By.cssSelector(".accordion__button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    @DisplayName("Проверка открытия первой стрелки")
    public void testFirstImportantQuestions() throws InterruptedException {
        objImportantQuestions.clickContents1List();
        Thread.sleep(1000);
        String text = objImportantQuestions.setContents1List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }

    @Test
    @DisplayName("Проверка открытия второй стрелки")
    public void testSecondImportantQuestions() {
        objImportantQuestions.clickContents2List();
        String text = objImportantQuestions.setContents2List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }

    @Test
    @DisplayName("Проверка открытия третьей стрелки")
    public void testThreeImportantQuestions() {
        objImportantQuestions.clickContents3List();
        String text = objImportantQuestions.setContents3List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }

    @Test
    @DisplayName("Проверка открытия четвертой стрелки")
    public void testFourImportantQuestions() {
        objImportantQuestions.clickContents4List();
        String text = objImportantQuestions.setContents4List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }
    @Test
    @DisplayName("Проверка открытия пятой стрелки")
    public void testFifthImportantQuestions() {
        objImportantQuestions.clickContents5List();
        String text = objImportantQuestions.setContents5List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }
    @Test
    @DisplayName("Проверка открытия шестой стрелки")
    public void testSixthImportantQuestions() {
        objImportantQuestions.clickContents6List();
        String text = objImportantQuestions.setContents6List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }
    @Test
    @DisplayName("Проверка открытия седьмой стрелки")
    public void testSevenImportantQuestions() {
        objImportantQuestions.clickContents7List();
        String text = objImportantQuestions.setContents7List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }
    @Test
    @DisplayName("Проверка открытия восьмой стрелки")
    public void testEightImportantQuestions() {
        objImportantQuestions.clickContents8List();
        String text = objImportantQuestions.setContents8List();
        assertFalse(text.isEmpty(), "Текст первого списка пустой");
    }

}
