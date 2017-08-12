package addressbook.tests;

        import addressbook.model.AddressBookComparator;
        import addressbook.model.AddressData;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.List;

public class AddAdrdessBook extends TestBase {

  @Test
  public void createAddressBook()
  {
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> before = app.getAddressBookHelper().getAddressBookList();
    app.getNavigationHelper().navigateToAddressBookPage();
    AddressData adressbook=new AddressData("firstname","lastname","street Test","test@mail.com","1111111");
    app.getAddressBookHelper().fillAddressBookForm(adressbook);
    app.getAddressBookHelper().submitCerationAddressBook();
    app.getNavigationHelper().navigateToHomePage();
    List<AddressData> after = app.getAddressBookHelper().getAddressBookList();
    Assert.assertEquals(after.size(),before.size()+1);
    before.add(adressbook);
    before.sort(new AddressBookComparator());
    Assert.assertEquals(after,before);


  }


}
