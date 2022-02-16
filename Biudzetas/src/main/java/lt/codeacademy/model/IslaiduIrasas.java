package lt.codeacademy.model;

import lt.codeacademy.type.AtsiskaitymoBudas;
import lt.codeacademy.type.IslaiduKategorija;

import java.io.Serializable;
import java.time.LocalDateTime;

public class IslaiduIrasas implements Serializable {
    private double suma;
    private LocalDateTime dataSuLaiku;
    private IslaiduKategorija kategorija;
    private AtsiskaitymoBudas atsiskaitymoBudas;
    private String papildomaInfo;

    public IslaiduIrasas() {
    }

    public IslaiduIrasas(double suma,
                         LocalDateTime dataSuLaiku,
                         IslaiduKategorija kategorija,
                         AtsiskaitymoBudas atsiskaitymoBudas,
                         String papildomaInfo) {
        this.suma = suma;
        this.dataSuLaiku = dataSuLaiku;
        this.kategorija = kategorija;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public void setDataSuLaiku(LocalDateTime dataSuLaiku) {
        this.dataSuLaiku = dataSuLaiku;
    }

    public IslaiduKategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(IslaiduKategorija kategorija) {
        this.kategorija = kategorija;
    }

    public AtsiskaitymoBudas getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(AtsiskaitymoBudas atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return "IslaiduIrasas{" +
                "suma=" + suma +
                ", dataSuLaiku=" + dataSuLaiku +
                ", kategorija=" + kategorija +
                ", atsiskaitymoBudas=" + atsiskaitymoBudas +
                ", papildomaInfo='" + papildomaInfo + '\'' +
                '}';
    }
}
