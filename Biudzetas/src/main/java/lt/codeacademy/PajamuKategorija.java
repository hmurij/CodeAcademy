package lt.codeacademy;

public enum PajamuKategorija {

    ATLYGINIMAS("Atlyginimas"), ISOMOKOS("Ismokos"), SOCIALINE_PARAMA("Socialinė parama"), HONORARAS("Honoraras"),
    NEDARBINGUMO_PAJAMOS("Nedarbinės pajamos"), RENTA("Renta");

    private final String katerorija;

    PajamuKategorija(String kategorija){
        this.katerorija = kategorija;
    }

    public String getKaterorija() {
        return katerorija;
    }

}
