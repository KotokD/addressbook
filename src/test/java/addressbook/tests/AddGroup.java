package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AddGroup extends TestBase {

  @Test
  public void testCreationGroup() {
    app.getNavigationHelper().navigateToHomePage();
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group=new GroupData(null, "test", "header", "footer");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitCrerationGroup();
    app.getNavigationHelper().navigateToGroupPage();
    List after = app.getGroupHelper().getGroupList();
    before.add(group);
    before.sort(new GroupDataComparator());
    after.sort(new GroupDataComparator());
    Assert.assertEquals(after,before);
  }


}
