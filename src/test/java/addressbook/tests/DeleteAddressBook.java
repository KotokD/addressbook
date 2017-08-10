package addressbook.tests;
import addressbook.model.AddressData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DeleteAddressBook extends TestBase  {
  @Test
  public  void deleteAddressBook(){
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> before= app.getAddressBookHelper().getAddressBookList();
    app.getAddressBookHelper().selectAddressBook(before.size()-1);
    app.getAddressBookHelper().initAddressBookRemove();
    app.getAddressBookHelper().submitAddressBookRemove();
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> after= app.getAddressBookHelper().getAddressBookList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);

      Assert.assertEquals(after,before);
  }
}
