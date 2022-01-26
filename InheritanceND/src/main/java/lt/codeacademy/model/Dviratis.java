package lt.codeacademy.model;

public class Dviratis extends TransportoPriemone{
    private int pavaruSkaicius;

    public Dviratis(int ratuSkaicius, String spalva, int pavaruSkaicius) {
        super(ratuSkaicius, spalva);
        this.pavaruSkaicius = pavaruSkaicius;
    }

    public void spausdinti(){
        super.spausdinti();
        System.out.print(" pavarus skaicius: " + pavaruSkaicius);
    }
}
