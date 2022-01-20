package lt.codeacademy;

import java.time.LocalDate;

public class PajamuIrasas {
    private double suma;
    private LocalDate data;
    private PajamuKategorija kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    public PajamuIrasas() {
    }

    public PajamuIrasas(double suma, LocalDate data, PajamuKategorija kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.suma = suma;
        this.data = data;
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public PajamuKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(PajamuKategorija kategorija) {
        this.kategorija = kategorija;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return "PajamuIrasas{" +
                "suma=" + suma +
                ", data=" + data +
                ", kategorija=" + kategorija +
                ", pozymisArIBanka=" + pozymisArIBanka +
                ", papildomaInfo='" + papildomaInfo + '\'' +
                '}';
    }
}
