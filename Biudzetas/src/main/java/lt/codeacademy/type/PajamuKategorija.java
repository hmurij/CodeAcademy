package lt.codeacademy.type;

public enum PajamuKategorija {

    ATLYGINIMAS("Atlyginimas"), ISOMOKOS("Ismokos"), SOC_PARAMA("Socialinė parama"), HONORARAS("Honoraras"),
    NEDARB_PAJAMOS("Nedarbinės pajamos"), RENTA("Renta");

    private final String katerorija;

    PajamuKategorija(String kategorija){
        this.katerorija = kategorija;
    }

    public String getKategorija() {
        return katerorija;
    }

}
