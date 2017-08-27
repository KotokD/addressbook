package addressbook.tests;
import addressbook.model.AddressBookComparator;
import addressbook.model.AddressData;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class DeleteAddressBook extends TestBase  {
  @BeforeMethod
  public void ensurePrecondition() {
    app.getNavigationHelper().navigateToHomePage();
    if (app.adressbook().isAddressBookThere() == false) {
      app.adressbook().createAddressBook(new AddressData("firstname", "lastname", "street Test", "test@mail.com", "1111111",null));
    }
  }
  @Test
  public  void deleteAddressBook(){
    List<AddressData> before= app.adressbook().getAddressBookList();
    int index=before.size()-1;
    app.adressbook().deleteAddressBook(index);
    List<AddressData> after= app.adressbook().getAddressBookList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);
    before.sort(new AddressBookComparator());
    after.sort(new AddressBookComparator());
    Assert.assertEquals(after,before);
  }
}
