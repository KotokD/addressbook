package addressbook.appmanager;

import addressbook.model.AddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddressBookHelper extends HelperBase {
  public NavigationHelper navigationHelper = new NavigationHelper(driver);

  public AddressBookHelper(WebDriver driver) {
    super(driver);
  }

  public void createAddressBook(AddressData adressbook) {
    getNavigationHelper().navigateToAddressBookPage();
    fillAddressBookForm(adressbook);
    submitCerationAddressBook();
    getNavigationHelper().navigateToHomePage();
  }

  public void editAddressBook(AddressData addressbook, int index) {
    getNavigationHelper().navigateToHomePage();
    initAddressBookModification(index);
    fillAddressBookForm(addressbook);
    submitAddressBookModification();
    getNavigationHelper().navigateToHomePage();
  }

  public void deleteAddressBook(int index) {
    getNavigationHelper().navigateToHomePage();
    selectAddressBook(index);
    initAddressBookRemove();
    submitAddressBookRemove();
    getNavigationHelper().navigateToHomePage();
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

  public void initAddressBookModification(int number) {
    driver.findElements(By.cssSelector("img[title ='Edit']")).get(number).click();

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

  public boolean isAddressBookThere() {
    if (isElementPresent(By.cssSelector("td.center")) == false) {
      return false;
    } else return true;
  }


  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public int getBookCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public List<AddressData> getAddressBookList() {
    List<AddressData> addressbooks = new ArrayList<AddressData>();
    List<WebElement> rows = driver.findElements(By.cssSelector(("tr[name]")));
    for (WebElement element : rows) {
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
      AddressData addressData = new AddressData(firstname, lastname, address, null, null);
      addressbooks.add(addressData);
    }
    return addressbooks;
  }
}