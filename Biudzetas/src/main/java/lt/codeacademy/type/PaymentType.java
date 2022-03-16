package lt.codeacademy.type;

public enum PaymentType implements Type {
    GRYNAIS("Grynais pinigais"),
    KORTELE("Banko kortele"),
    PAVEDIMU("Banko pavedimu");

    private final String type;

    PaymentType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
