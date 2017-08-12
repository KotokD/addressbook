package addressbook.tests;

import addressbook.model.AddressData;
import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.junit.Test;

import java.security.acl.Group;
import java.util.List;

public class DeleteGroup  extends TestBase{
  @Test
  public  void testdeleteGroup() {
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> before= app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().initGroupkRemove();
    app.getNavigationHelper().navigateToGroupPage();
    List<GroupData> after= app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);
    before.sort(new GroupDataComparator());
    Assert.assertEquals(after,before);
  }
}
