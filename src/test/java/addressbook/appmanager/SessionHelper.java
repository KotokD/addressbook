package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void signIn(String user, String pass) {
    type(By.name("user"), user);
    type(By.name("pass"), pass);
    click(By.cssSelector("[value='Login']"));
  }


}
