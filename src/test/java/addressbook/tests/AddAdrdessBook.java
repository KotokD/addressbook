package addressbook.tests;

import addressbook.model.AddressBookComparator;
import addressbook.model.AddressData;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AddAdrdessBook extends TestBase {

  @Test
  public void createAddressBook() {
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> before = app.adressbook().getAddressBookList();
    AddressData adressbook = new AddressData("firstname", "lastname", "street Test", "test@mail.com", "1111111");
    app.adressbook().createAddressBook(adressbook);
    List<AddressData> after = app.adressbook().getAddressBookList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(adressbook);
    before.sort(new AddressBookComparator());
    after.sort(new AddressBookComparator());
    Assert.assertEquals(after, before);

  }


}
