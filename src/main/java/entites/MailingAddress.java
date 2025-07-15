package entites;

public class MailingAddress {
     public int streetNumber;
     public String streetLabel;
     public int postalCode;
     public String city;

     // Constructeur
     public MailingAddress(int streetNumber,
                           String streetLabel, int postalCode, String city) {
          this.streetNumber = streetNumber;
          this.streetLabel = streetLabel;
          this.postalCode = postalCode;
          this.city = city;
     }
}