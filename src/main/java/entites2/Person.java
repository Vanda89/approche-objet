package entites2;

import entites.MailingAddress;

public class Person {
    public String lastName;
    public String firstName;
    public MailingAddress address;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public Person(
                   String lastName,
                   String firstName,
                  MailingAddress address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

    public void displayName()  {
        System.out.println(this.lastName +
                " " + this.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setAddress(MailingAddress address) {
        this.address = address;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public MailingAddress getAddress() {
        return this.address;
    }


}

