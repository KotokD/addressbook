package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void navigateToAddressBookPage() {
    click(By.linkText("add new"));
  }

  public void navigateToHomePage() {
    if (!isElementPresent(By.id("maintable"))) {
      click(By.linkText("home"));
    }
  }
}