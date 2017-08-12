package addressbook.model;

import java.util.Comparator;

public class GroupDataComparator implements Comparator<GroupData> {

  @Override
  public int compare(GroupData o1, GroupData o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
