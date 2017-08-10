package addressbook.appmanager;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;


public class AppManager {

  protected WebDriver driver;
  protected String browser;
  private AddressBookHelper addressBookHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;

  public AppManager(String browser) {
    this.browser=browser;
  }

  @Test

  public void init() {
    if(browser.equals(org.openqa.selenium.remote.BrowserType.CHROME) )
      driver= new ChromeDriver();
    else if (browser.equals(org.openqa.selenium.remote.BrowserType.FIREFOX))
    {
      driver= new FirefoxDriver();
    }
    else if (browser.equals(org.openqa.selenium.remote.BrowserType.EDGE))
    {
      driver= new EdgeDriver();
    }
    driver.get("http://localhost/addressbook/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    addressBookHelper = new AddressBookHelper(driver);
    sessionHelper= new SessionHelper(driver);
    navigationHelper =new NavigationHelper(driver);
    sessionHelper.signIn("admin", "secret");
  }


  public void stop() {
    driver.quit();
  }

  public AddressBookHelper getAddressBookHelper() {
    return addressBookHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}