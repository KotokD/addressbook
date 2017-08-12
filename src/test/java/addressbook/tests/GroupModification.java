package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GroupModification extends TestBase {
  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> before= app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group= new GroupData("modify","header","footer");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> after= app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(),after.size());
    before.remove(before.size()-1);
    before.add(after.size()-1,group);
    before.sort(new GroupDataComparator());
    Assert.assertEquals(before,after);
  }
}
