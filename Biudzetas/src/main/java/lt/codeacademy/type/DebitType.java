package lt.codeacademy.type;

public enum DebitType implements Type {
    TURTAS("Nekilnojamojo turto įsigijimas"),
    STATYBA("Statyba, rekonstravimas, remontas ir kiti darbai"),
    REMONTAS("Paprastasis remontas"),
    TRANSPOTAS("Transportavimo islaidos"),
    IRANGA("Kompiuterinė ir programinė  įranga");

    private final String type;

    DebitType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
