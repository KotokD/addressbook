package addressbook.appmanager;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase{
  public NavigationHelper navigationHelper;
  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }
  public void initGroupCreation( ) {
    driver.findElement(By.cssSelector("[value='New group'")).click();

  }

  public void selectGroup(int number) {

    driver.findElements(By.name("selected[]")).get(number).click();
  }

  public void initGroupModification( ) {
    driver.findElement(By.name("edit")).click();

  }

  public void initGroupkRemove() {
    click(By.name("delete"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void submitCrerationGroup() {
    click(By.name("submit"));
  }

  public boolean isGroupThere(){
    if(isElementPresent(By.name("selected[]"))==false){
      return false;
    }
    else return true;
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups= new ArrayList<GroupData>();
    List <WebElement> elements =driver.findElements(By.cssSelector("span.group"));
    for(WebElement element: elements){
      String name=element.getText();
      String id=element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group= new GroupData(id,name,null,null);
      groups.add(group);
    }
    return groups;
  }
}
