package addressbook.tests;

        import addressbook.model.AddressData;
        import org.junit.Assert;
        import org.junit.Test;

public class AddAdrdessBook extends TestBase {

  @Test
  public void createAddressBook()
  {
    app.getNavigationHelper().navigateToHomePage();
    int before = app.getAddressBookHelper().getBookCount();
    app.getNavigationHelper().navigateToAddressBookPage();
    app.getAddressBookHelper().fillAddressBookForm(new AddressData("firstname","lastname","street Test","test@mail.com","1111111"));
    app.getAddressBookHelper().submitCerationAddressBook();
    app.getNavigationHelper().navigateToHomePage();
    int after = app.getAddressBookHelper().getBookCount();
    Assert.assertEquals(after,before+1);


  }


}
