package lt.codeacademy;

public enum IslaiduKategorija {
    TURTAS("Nekilnojamojo turto įsigijimas"),
    STATYBA("Statyba, rekonstravimas, remontas ir kiti darbai"),
    REMONTAS("Paprastasis remontas"),
    TRANSPOTAS("Transportavimo islaidos"),
    IRANGA("Kompiuterinė ir programinė  įranga");

    private final String kategorija;

    IslaiduKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getKategorija() {
        return kategorija;
    }
}
