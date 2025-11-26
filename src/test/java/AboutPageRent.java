import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPageRent {
    private WebDriver driver;
    //локатор для поля * Когда привезти самокат
    private By deliveryField = By.xpath(".//input[@type='text' and @placeholder='* Когда привезти самокат']");
    //локатор для поля * Когда привезти самокат * Срок аренды
    private By rentalField = By.className("Dropdown-placeholder");
    //локатор для чекбокса черный жемчуг
    private By blackPearl = By.id("black");
    //локатор для чекбокса черный жемчуг серая безысходность
    private By grayHopelessness = By.id("grey");
    //локатор для поля * Когда привезти самокат Комментарий для курьера
    private By commentСourier = By.xpath(".//input[@type='text' and @placeholder='Комментарий для курьера']");
    //лоатор для кнопки заказать
    private By orderButton = By.xpath(".//button[contains(text(), 'Заказать') and @class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для кнопки ДА в оформлении заказа
    private By consentRegistration = By.xpath(".//button[contains(text(), 'Да') and @class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutPageRent(WebDriver driver){
        this.driver = driver;
    }

    public void clickDeliveryField()  {
        driver.findElement(deliveryField).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker-popper")));
        driver.findElement(By.xpath(".//div[contains(@class, 'react-datepicker__day') and text()='25']")).click();

    }
    public void clickRentalField(String rentalPeriod) {
        driver.findElement(rentalField).click();
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();

    }
    public void clickBlackPearl() {
        driver.findElement(blackPearl).click();

    }
    public void clickGrayHopelessness()  {
        driver.findElement(grayHopelessness).click();

    }
    public void setCommentСourier(String comment){
        driver.findElement(commentСourier).sendKeys(comment);
    }
    public void clickOrderButton()  {
        driver.findElement(orderButton).click();

    }
    public void clickConsentRegistration(){
        driver.findElement(consentRegistration).click();
    }

    public void aboutRent(String rentalPeriod,String color,String comment )  {
        clickDeliveryField();
        clickRentalField(rentalPeriod);
        if (color.equals("black")) {
            clickBlackPearl();
        }else{
            clickGrayHopelessness();
        }

        setCommentСourier(comment);
        clickOrderButton();
        clickConsentRegistration();
    }

}




