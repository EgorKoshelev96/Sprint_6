import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageScooterTest {
    private WebDriver driver;
    //Локатор для верхней кнопки заказа
    private By orderButtonTop = By.xpath(".//button[contains(text(), 'Заказать') and @class = 'Button_Button__ra12g']");
    //Локатор для нижней кнопки заказа
    private By orderButtonBottom = By.xpath
            (".//button[contains(text(), 'Заказать') and @class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для поля Имя
    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //Локатор для поля Фамилия
    private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Локатор для поля Адрес: куда привезти заказ
    private  By addressField = By.xpath
            (".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Локатор для поля Станция метро
    private By metroStationField = By.xpath
            (".//input[@placeholder = '* Станция метро']");
    //Локатор для поля Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath
            (".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Локатор для кнопки Далее
    private By nextButton = By.xpath
            (".//button[contains(text(), 'Далее') and @class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageScooterTest(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void setNameField(String name) {

        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddressField(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStationField(String metro){

        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metro);
        WebElement options = driver.findElement(By.xpath(".//div[text()='"+metro+"']"));
        options.click();




    }

    public void setPhoneNumberField(String phone) {
        driver.findElement(phoneNumberField).sendKeys(phone);

    }

    public void setNextButton() {
        driver.findElement(nextButton).click();

    }

    public void fillingScooterFields(String name, String surname, String address, String metro, String phone, String buttonType) throws InterruptedException {
        if (buttonType.equals("top")) {
            clickOrderButtonTop();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Logo__23yGT")));
            WebElement element = driver.findElement(orderButtonTop);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        }else {
            //ЗАКРЫВАЕМ БАНЕР С КУКИ
            try {
                WebElement cookieBanner = driver.findElement(By.className("App_CookieConsent__1yUIN"));
                WebElement closeButton = cookieBanner.findElement(By.tagName("button"));
                closeButton.click();
            } catch (NoSuchElementException e) {
                System.out.println("Баннер cookies не найден или уже закрыт");
            }
            clickOrderButtonBottom();
        }

        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setMetroStationField(metro);
        setPhoneNumberField(phone);
        setNextButton();
    }





}

