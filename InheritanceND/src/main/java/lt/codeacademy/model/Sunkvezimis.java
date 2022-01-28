package lt.codeacademy.model;

public class Sunkvezimis extends Automobilis {
    private double krovinioTalpa;
    private double krovinioSvoris;

    public Sunkvezimis(int ratuSkaicius,
                       String spalva,
                       KuroTipas kuroTipas,
                       double variklioTuris,
                       int cilindruSkaicius,
                       double krovinioTalpa,
                       double krovinioSvoris) {
        super(ratuSkaicius, spalva, kuroTipas, variklioTuris, cilindruSkaicius);
        this.krovinioTalpa = krovinioTalpa;
        this.krovinioSvoris = krovinioSvoris;
    }

    public void spausdinti(){
        super.spausdinti();
        System.out.print(" krovinion talpa: " + krovinioTalpa + " krovinioSvoris: " + krovinioSvoris);

    }
}
