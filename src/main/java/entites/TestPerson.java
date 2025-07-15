package entites;

import entites2.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person pers1 = new Person("Georges", "Dupont");

        MailingAddress adr2 =
                new MailingAddress(2, "GrandRue", 30000, "Nîmes");
        Person pers2 = new Person(
                "Françoise", "Durand", adr2);

        System.out.println(pers1.firstName + " " + pers1.lastName);

        System.out.println(pers2.firstName + " " + pers2.lastName + ", " +
                pers2.address.streetNumber + " " + pers2.address.streetLabel + ", " +
                pers2.address.postalCode + " " + pers2.address.city);

    }
}
