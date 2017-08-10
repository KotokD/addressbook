package addressbook.appmanager;

import addressbook.model.AddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddressBookHelper extends HelperBase {
public NavigationHelper navigationHelper;

  public AddressBookHelper(WebDriver driver) {
    super(driver);
  }

  public void fillAddressBookForm(AddressData addressData) {
    type(By.name("firstname"), addressData.getFirstname());
    type(By.name("lastname"), addressData.getLastname());
    type(By.name("address"), addressData.getAddress());
    type(By.name("mobile"), addressData.getPhone());
    type(By.name("email"), addressData.getEmail());
  }

  public void selectAddressBook(int number) {

      driver.findElements(By.name("selected[]")).get(number).click();

  }

  public void initAddressBookModification() {
    driver.findElement(By.cssSelector("value ='Edit'")).click();

  }

  public void initAddressBookRemove() {
    click(By.cssSelector("[value='Delete']"));
  }

  public void submitAddressBookModification() {
    click(By.name("update"));
  }

  public void submitCerationAddressBook() {
    click(By.name("submit"));
  }

  public void submitAddressBookRemove() {
    driver.switchTo().alert().accept();
  }

  public boolean isAddressBookThere(){
    if(isElementPresent(By.cssSelector("td.center"))==false){
      return false;
    }
    else return true;
  }
  public void createAddressBook()
  {
    ;

  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public int getBookCount() {
   return driver.findElements(By.name("selected[]")).size();
  }

  public List<AddressData> getAddressBookList() {
    List<AddressData> addressbooks= new ArrayList<AddressData>();
    List <WebElement> elements_lastname =driver.findElements(By.cssSelector(("tr[name] td:nth-child(2)")));
    for(WebElement element: elements_lastname){
      String lastname=element.getText();
      AddressData addressData= new AddressData(null,lastname,null,null,null);
      addressbooks.add(addressData);
    }
    return addressbooks;
  }
}