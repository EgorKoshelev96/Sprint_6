import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String setContents1List() {
        return driver.findElement(contents1List).getText();
    }

    public void clickContents2List() {
        driver.findElement(list2Switch).click();
    }

    public String setContents2List() {
        return driver.findElement(contents2List).getText();
    }

    public void clickContents3List() {
        driver.findElement(list3Switch).click();
    }

    public String setContents3List() {
        return driver.findElement(contents3List).getText();
    }

    public void clickContents4List() {
        driver.findElement(list4Switch).click();
    }

    public String setContents4List(){
        return driver.findElement(contents4List).getText();
    }

    public void clickContents5List() {
        driver.findElement(list5Switch).click();
    }

    public String setContents5List(){
        return driver.findElement(contents5List).getText();
    }

    public void clickContents6List() {
        driver.findElement(list6Switch).click();
    }

    public String setContents6List(){
        return driver.findElement(contents6List).getText();
    }

    public void clickContents7List() {
        driver.findElement(list7Switch).click();
    }

    public String setContents7List(){
        return driver.findElement(contents7List).getText();
    }

    public void clickContents8List() {
        driver.findElement(list8Switch).click();
    }

    public String setContents8List(){
        return driver.findElement(contents8List).getText();
    }




}
