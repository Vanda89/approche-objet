package entites;

public class TestMailingAdress {
    public static void main(String[] args) {
        MailingAdress adr1 = new MailingAdress();
        adr1.streetNumber = 15;
        adr1.streetLabel = "GrandRue";
        adr1.postalCode = 34090;
        adr1.city = "Montpellier";

        MailingAdress adr2 = new MailingAdress();
        adr2.streetNumber = 2;
        adr2.streetLabel = "GrandRue";
        adr2.postalCode = 30000;
        adr2.city = "Nîmes";

    }
}
