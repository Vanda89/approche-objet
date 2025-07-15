package entites;

import entites2.Person;

public class TestPerson {
    public static void main(String[] args) {
        MailingAdress adr1 =
                new MailingAdress();
        adr1.streetNumber = 15;
        adr1.streetLabel = "GrandRue";
        adr1.postalCode = 34090;
        adr1.city = "Montpellier";

        Person pers1 = new Person();
        pers1.firstName = "Georges";
        pers1.lastName = "Dupont";
        pers1.adress = adr1;

        MailingAdress adr2 =
                new MailingAdress();
        adr2.streetNumber = 2;
        adr2.streetLabel = "GrandRue";
        adr2.postalCode = 30000;
        adr2.city = "Nîmes";

        Person pers2 = new Person();
        pers2.firstName = "Françoise";
        pers2.lastName = "Durand";
        pers2.adress = adr2;
    }
}
