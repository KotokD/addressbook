package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isElementPresent(By locator)
  {
    try {
      driver.findElement(locator);
      return true;
    }
    catch(NoSuchElementException ex)
    {
      return false;
    }
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    if (text != null) {
      String existText = driver.findElement(locator).getAttribute("value");
      if (existText.equals(text) == false) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    }
  }

}
