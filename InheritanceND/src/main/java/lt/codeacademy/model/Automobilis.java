package lt.codeacademy.model;

public class Automobilis extends TransportoPriemone {
    private KuroTipas kuroTipas;
    private double variklioTuris;
    private int cilindruSkaicius;

    public Automobilis(int ratuSkaicius, String spalva, KuroTipas kuroTipas, double variklioTuris, int cilindruSkaicius) {
        super(ratuSkaicius, spalva);
        this.kuroTipas = kuroTipas;
        this.variklioTuris = variklioTuris;
        this.cilindruSkaicius = cilindruSkaicius;
    }

    public void spausdinti() {
        super.spausdinti();
        System.out.print(" kuro tipas: " + kuroTipas + " variklio turis: " + variklioTuris +
                " cilindru skaicius: " + cilindruSkaicius);

    }
}
