package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.GroupDataComparator;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.CoreMatchers.equalTo;

public class GroupModification extends TestBase {
  @BeforeMethod
  public void ensurePrecondition()
  {
    app.getNavigationHelper().navigateToGroupPage();
    if(app.group().isGroupThere()==false)
    {
      app.group().createGroup( new GroupData().withName("test").withHeader("header").withFooter("footer"));
    }
  }
  @Test
  public void testGroupModification()
  {
    List<GroupData> before= app.group().getGroupList();
    GroupData group= new  GroupData().withName("modify").withHeader("header").withFooter("footer");
    int index=before.size()-1;
    app.group().modifyGroup(group, index);
    List<GroupData> after= app.group().getGroupList();
    MatcherAssert.assertThat(before.size(),equalTo(after.size()));
    before.remove(before.size()-1);
    before.add(after.size()-1,group);
    before.sort(new GroupDataComparator());
    MatcherAssert.assertThat(before, equalTo(after));
  }


}
