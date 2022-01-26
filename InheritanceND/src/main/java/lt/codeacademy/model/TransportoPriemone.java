package lt.codeacademy.model;

public class TransportoPriemone {
    private int ratuSkaicius;
    private String spalva;

    public TransportoPriemone(){
        this.ratuSkaicius = 0;
        this.spalva = "nežinoma";
    }

    public TransportoPriemone(int ratuSkaicius, String spalva) {
        this.ratuSkaicius = ratuSkaicius;
        this.spalva = spalva;
    }

    public void spausdinti(){
        System.out.print("ratu skaicius: " + ratuSkaicius + " spalva: " + spalva);
    }
}
