package addressbook.tests;

import addressbook.model.AddressBookComparator;
import addressbook.model.AddressData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class AddressBookModification extends TestBase{
  @Test
  public void testAddressBookModification()
  {
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> before= app.getAddressBookHelper().getAddressBookList();
    app.getAddressBookHelper().initAddressBookModification(before.size()-1);
    AddressData addressbook= new AddressData("testmodify","testlastname","teststreet Test","modifytest@mail.com","21111111");
    app.getAddressBookHelper().fillAddressBookForm(addressbook);
    app.getAddressBookHelper().submitAddressBookModification();
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> after = app.getAddressBookHelper().getAddressBookList();
    before.remove(before.size()-1);
    before.add(addressbook);
    before.sort(new AddressBookComparator());
    Assert.assertEquals(before.size(),after.size());
    Assert.assertEquals(before,after);
  }

}
