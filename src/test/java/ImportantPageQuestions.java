import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantPageQuestions {
    private WebDriver driver;
    //локатор для всплывающего списка 1
    private By list1Switch = By.id("accordion__heading-0");
    //локатор для содержимого списка 1
    private By contents1List = By.id("accordion__panel-0");
    //локатор для всплывающего списка 2
    private By list2Switch = By.id("accordion__heading-1");
    //локатор для содержимого списка 2
    private By contents2List = By.id("accordion__panel-1");
    //локатор для всплывающего списка 3
    private By list3Switch = By.id("accordion__heading-2");
    //локатор для содержимого списка 3
    private By contents3List = By.id("accordion__panel-2");
    //локатор для всплывающего списка 4
    private By list4Switch = By.id("accordion__heading-3");
    //локатор для содержимого списка 4
    private By contents4List = By.id("accordion__panel-3");
    //локатор для всплывающего списка 5
    private By list5Switch = By.id("accordion__heading-4");
    //локатор для содержимого списка 5
    private By contents5List = By.id("accordion__panel-4");
    //локатор для всплывающего списка 6
    private By list6Switch = By.id("accordion__heading-5");
    //локатор для содержимого списка 6
    private By contents6List = By.id("accordion__panel-5");
    //локатор для всплывающего списка 7
    private By list7Switch = By.id("accordion__heading-6");
    //локатор для содержимого списка 7
    private By contents7List = By.id("accordion__panel-6");
    //локатор для всплывающего списка 8
    private By list8Switch = By.id("accordion__heading-7");
    //локатор для содержимого списка 8
    private By contents8List = By.id("accordion__panel-7");

    public ImportantPageQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContents1List() {
        driver.findElement(list1Switch).click();
    }

    public void setContents1List(String expectedFirstText) {
        String actualFirstText = driver.findElement(contents1List).getText().trim();
        assertEquals(expectedFirstText, actualFirstText, "Текст не совпадает: " + "ожидалось " + expectedFirstText + ", " + "но получено " + actualFirstText);
    }

    public void clickContents2List() {
        driver.findElement(list2Switch).click();
    }

    public void setContents2List(String expectedSecondText) {
        String actualSecondText = driver.findElement(contents2List).getText().trim();
        assertEquals(expectedSecondText, actualSecondText, "Текст не совпадает: " + "ожидалось " + expectedSecondText + ", " + "но получено " + actualSecondText);

    }

    public void clickContents3List() {
        driver.findElement(list3Switch).click();
    }

    public void setContents3List(String expectedThreeText) {
        String actualThreeText = driver.findElement(contents3List).getText().trim();
        assertEquals(expectedThreeText,actualThreeText, "Текст не совпадает: " + "ожидалось " + expectedThreeText + ", " + "но получено " + actualThreeText);

    }

    public void clickContents4List() {
        driver.findElement(list4Switch).click();
    }

    public void setContents4List(String expectedFourText) {
        String actualFourText = driver.findElement(contents4List).getText().trim();
        assertEquals(expectedFourText,actualFourText, "Текст не совпадает: " + "ожидалось " + expectedFourText + ", " + "но получено " + actualFourText);

    }

    public void clickContents5List() {
        driver.findElement(list5Switch).click();
    }

    public void setContents5List(String expectedFifthText) {
        String actualFifthText = driver.findElement(contents5List).getText().trim();
        assertEquals(expectedFifthText,actualFifthText, "Текст не совпадает: " + "ожидалось " + expectedFifthText + ", " + "но получено " + actualFifthText);

    }

    public void clickContents6List() {
        driver.findElement(list6Switch).click();
    }

    public void setContents6List(String expectedSixthText) {
        String actualSixthText = driver.findElement(contents6List).getText().trim();
        assertEquals(expectedSixthText,actualSixthText, "Текст не совпадает: " + "ожидалось " + expectedSixthText + ", " + "но получено " + actualSixthText);

    }

    public void clickContents7List() {
        driver.findElement(list7Switch).click();
    }

    public void setContents7List(String expectedSevenText) {
        String actualSevenText = driver.findElement(contents7List).getText().trim();
        assertEquals(expectedSevenText,actualSevenText, "Текст не совпадает: " + "ожидалось " + expectedSevenText + ", " + "но получено " + actualSevenText);

    }

    public void clickContents8List() {
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        driver.findElement(list8Switch).click();
    }

    public void setContents8List(String expectedEightText) {
        String actualEightText = driver.findElement(contents8List).getText().trim();
        assertEquals(expectedEightText,actualEightText, "Текст не совпадает: " + "ожидалось " + expectedEightText + ", " + "но получено " + actualEightText);

    }

    public void testImportantQuestions(String expectedFirstText,String expectedSecondText,String expectedThreeText,String expectedFourText,String expectedFifthText,String expectedSixthText,
                                       String expectedSevenText,String expectedEightText){

        clickContents1List();
        setContents1List(expectedFirstText);
        clickContents2List();
        setContents2List(expectedSecondText);
        clickContents3List();
        setContents3List(expectedThreeText);
        clickContents4List();
        setContents4List(expectedFourText);
        clickContents5List();
        setContents5List(expectedFifthText);
        clickContents6List();
        setContents6List(expectedSixthText);
        clickContents7List();
        setContents7List(expectedSevenText);
        clickContents8List();
        setContents8List(expectedEightText);
    }


}
