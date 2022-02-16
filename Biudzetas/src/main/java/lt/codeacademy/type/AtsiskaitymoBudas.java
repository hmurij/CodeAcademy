package lt.codeacademy.type;

public enum AtsiskaitymoBudas {
    GRYNAIS("Grynais pinigais"), KORTELE("Banko kortele"), PAVEDIMU("Banko pavedimu");

    private final String tsiskaitymoBudas;

    AtsiskaitymoBudas(String tsiskaitymoBudas) {
        this.tsiskaitymoBudas = tsiskaitymoBudas;
    }

    public String getAtsiskaitymoBudas() {
        return tsiskaitymoBudas;
    }
}
