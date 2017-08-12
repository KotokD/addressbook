package addressbook.model;

import java.util.Comparator;

public class AddressBookComparator implements Comparator<AddressData> {
  @Override
  public int compare(AddressData o1, AddressData o2) {
    return o1.getLastname().compareTo(o2.getLastname());
  }
}
