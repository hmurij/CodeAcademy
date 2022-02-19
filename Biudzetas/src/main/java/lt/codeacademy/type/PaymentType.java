package lt.codeacademy.type;

public enum PaymentType {
    GRYNAIS("Grynais pinigais"),
    KORTELE("Banko kortele"),
    PAVEDIMU("Banko pavedimu");

    private final String type;

    PaymentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
