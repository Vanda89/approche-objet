package entites2;

import entites.MailingAddress;

public class Person {
    public String firstName;
    public String lastName;
    public MailingAddress address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName,
                   String lastName,
                  MailingAddress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


}

