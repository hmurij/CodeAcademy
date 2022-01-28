package lt.codeacademy;


import lt.codeacademy.model.*;

public class App
{
    public static void main( String[] args )
    {

        TransportoPriemone tp1 = new TransportoPriemone();
        System.out.print("Transporto priemone: ");
        tp1.spausdinti();
        System.out.println();

        TransportoPriemone tp2 = new TransportoPriemone(4, "Raudona");
        System.out.print("Transporto priemone: ");
        tp2.spausdinti();
        System.out.println();

        Dviratis dv = new Dviratis(2, "Mėlyna", 6);
        System.out.print("Dviratis: ");
        dv.spausdinti();
        System.out.println();

        Automobilis au = new Automobilis(4, "Juoda", KuroTipas.BENZINAS, 2.0, 4);
        System.out.print("Automobilis: ");
        au.spausdinti();
        System.out.println();

        Sunkvezimis su = new Sunkvezimis(6, "Geltona", KuroTipas.DIZELIS, 4.0, 6,
                10.0, 20.0);
        System.out.print("Sunkvezimis");
        su.spausdinti();

    }
}
