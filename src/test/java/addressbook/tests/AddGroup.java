package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AddGroup extends TestBase {

  @Test
  public void testCreationGroup() {
    app.group().navigateToGroupPage();
    List<GroupData> before = app.group().getGroupList();
    GroupData group=new GroupData( "test", "header", "footer");
    app.group().createGroup(group);
    List after = app.group().getGroupList();
    before.add(group);
    before.sort(new GroupDataComparator());
    after.sort(new GroupDataComparator());
    Assert.assertEquals(after,before);
  }




}
