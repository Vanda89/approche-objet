package poo_java10;

public enum Couleur {
    ROUGE("R"), VERT("V"), BLEU("B"), JAUNE("J"), NOIR("N");

    public static Couleur getCouleurDefault() {
        return NOIR;
    }
    private String code;

    Couleur(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
