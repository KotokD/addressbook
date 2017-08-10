package addressbook.tests;

import addressbook.appmanager.AppManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

  protected final AppManager app = new AppManager(BrowserType.CHROME);

  @Before
  public void setUp() {
    app.init();
  }

  @After
  public void teatDown() {
    app.stop();
  }

}


