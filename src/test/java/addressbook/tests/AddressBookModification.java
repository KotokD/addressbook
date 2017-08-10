package addressbook.tests;

import addressbook.model.AddressData;
import org.junit.Test;

public class AddressBookModification extends TestBase{
  @Test
  public void testAddressBookModification()
  {
    app.getNavigationHelper().navigateToHomePage();
    app.getAddressBookHelper().initAddressBookModification();
    app.getAddressBookHelper().fillAddressBookForm(new AddressData("testmodify","lastname","street Test","test@mail.com","1111111"));
    app.getAddressBookHelper().submitAddressBookModification();
    app.getNavigationHelper().navigateToHomePage();
  }

}
