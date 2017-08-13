package addressbook.tests;
import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

  public class DeleteGroup extends TestBase {
    public class GroupModification extends TestBase {
      @BeforeMethod
      public void ensurePrecondition() {
        app.group().navigateToGroupPage();
        if (app.group().isGroupThere() == false) {
          app.group().createGroup(new GroupData("test1", "header", "footer"));
        }
      }

      @Test
      public void testDeleteGroup() {
        List<GroupData> before = app.group().getGroupList();
        int index = before.size() - 1;
        app.group().deleteGroup(index);
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        before.sort(new GroupDataComparator());
        Assert.assertEquals(after, before);
      }
    }
  }

