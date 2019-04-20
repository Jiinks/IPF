package IPF_Ex.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import IPF_Ex.driver.FireFox;

/**
 * WebElementH
 */
public class WebElementH implements Element {
    private final WebElement webElement;
    private final WebDriverWait wait;
    private final int timeOut = 15;

    public WebElementH(By by){
        this.wait = new WebDriverWait(FireFox.GetDriver(), this.timeOut);
        this.webElement = this.wait.until(ExpectedConditions.presenceOfElementLocated(by));            
    }

    private void MoveToElement() {
        ((JavascriptExecutor) FireFox.GetDriver()).executeScript("arguments[0].scrollIntoView(true);", this.webElement);

        try {
            Thread.sleep(200);
        } catch (Exception e) {
            // Log e
        }
    }

    @Override
    public void click() {
        this.MoveToElement();
        this.webElement.click();
    }

    @Override
    public void submit() {
        this.MoveToElement();
        this.webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this.MoveToElement();
        this.webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        this.MoveToElement();
        this.webElement.clear();
    }

    public void enterText(String text){
        clear();
        sendKeys(text);
    }

    @Override
    public String getTagName() {
        return this.webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return this.webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return this.webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.webElement.isEnabled();
    }

    @Override
    public String getText() {
        return this.webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        this.MoveToElement();
        return this.webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return this.webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return this.webElement.getScreenshotAs(target);
    }
    
    
}