import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantQuestions {
    private WebDriver driver;
    ImportantPageQuestions objImportantQuestions = new ImportantPageQuestions(driver);

    @BeforeEach
    public void setUp() {
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

    @ParameterizedTest
    @CsvSource( delimiter = '|', value = {
            "0| Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "1| Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "2| Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "3| Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "4| Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "5| Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "6| Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "7| Да, обязательно. Всем самокатов! И Москве, и Московской области."
    })

    void questionsTest(int index, String expectedText) {

        objImportantQuestions.clickContentsList(index);
        String actualText = objImportantQuestions.getContentsList(index);
        assertEquals(expectedText, actualText,"Текст не совпадает ожидалось: " + expectedText + ", но получено " + actualText);
    }

}



