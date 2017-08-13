package addressbook.tests;
import addressbook.model.AddressBookComparator;
import addressbook.model.AddressData;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

public class AddressBookModification extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.getNavigationHelper().navigateToHomePage();
    if (app.adressbook().isAddressBookThere() == false) {
      app.adressbook().createAddressBook(new AddressData
              ("firstname", "lastname", "street Test", "test@mail.com", "1111111"));
    }
  }

  @Test
  public void testAddressBookModification() {
    List<AddressData> before = app.adressbook().getAddressBookList();
    AddressData addressbook = new AddressData("testmodify", "testlastname", "teststreet Test", "modifytest@mail.com", "21111111");
    int index = before.size() - 1;
    app.adressbook().editAddressBook(addressbook, index);
    List<AddressData> after = app.adressbook().getAddressBookList();
    before.remove(index);
    before.add(addressbook);
    before.sort(new AddressBookComparator());
    after.sort(new AddressBookComparator());
    Assert.assertEquals(before.size(), after.size());
    Assert.assertEquals(before, after);
  }

}
