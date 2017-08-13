package addressbook.tests;

import addressbook.appmanager.AppManager;;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static final AppManager app = new AppManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite
  public void teatDown() {
    app.stop();
  }

}


