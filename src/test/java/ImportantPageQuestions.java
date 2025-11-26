import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportantPageQuestions {
    private WebDriver driver;

    private By listSwitch(int index) {
        return  By.id("accordion__heading-" + index);
    }
    private By contentsList(int index) {
        return By.id("accordion__panel-" + index);
    }

    public ImportantPageQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContentsList(int index) {
        WebElement clickContents = driver.findElement(listSwitch(index));
        clickContents.click();
    }

    public String getContentsList(int index) {
        WebElement contentsList = driver.findElement(contentsList(index));
        return contentsList.getText().trim();
    }
}
