package lt.codeacademy.type;

public enum IncomeType {

    ATLYGINIMAS("Atlyginimas"),
    ISOMOKOS("Ismokos"),
    SOC_PARAMA("Socialinė parama"),
    HONORARAS("Honoraras"),
    NEDARB_PAJAMOS("Nedarbinės pajamos"),
    RENTA("Renta");

    private final String type;

    IncomeType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
