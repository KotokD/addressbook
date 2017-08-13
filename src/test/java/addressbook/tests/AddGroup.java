package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AddGroup extends TestBase {

  @Test
  public void testCreationGroup() {
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> before = app.group().getGroupList();
    GroupData testgroup = new GroupData().
            withName("test").withHeader("header").withFooter("footer");
    app.group().createGroup(testgroup);
    List after = app.group().getGroupList();
    before.add(testgroup);
    before.sort(new GroupDataComparator());
    after.sort(new GroupDataComparator());
    Assert.assertEquals(after,before);
  }




}
