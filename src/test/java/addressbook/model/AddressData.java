package addressbook.model;

public class AddressData {
  String firstname;
  String lastname;
  String address;
  String email;
  String phone;

  public AddressData(String firstname,String lastname, String address, String email, String phone)
  {
    this.firstname=firstname;
    this.lastname=lastname;
    this.address=address;
    this.email=email;
    this.phone=phone;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }
}
