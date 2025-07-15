package entites;

import entites2.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person pers1 = new Person(
                "Dupont","Georges");

        MailingAddress adr2 =
                new MailingAddress(2, "GrandRue", 30000, "Nîmes");
        Person pers2 = new Person(
                 "Durand", "Françoise");
        pers2.setAddress(adr2);

        pers2.displayName();
        System.out.println(pers2.getAddress().streetNumber + " " + pers2.getAddress().streetLabel + ", " +
                pers2.getAddress().postalCode +
                " " + pers2.getAddress().city);

    }
}
