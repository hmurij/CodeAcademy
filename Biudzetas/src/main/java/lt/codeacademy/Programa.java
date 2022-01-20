package lt.codeacademy;

import java.util.Arrays;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa
{
    public static void main( String[] args )
    {
        System.out.println( "Interaktyvia programą - Biudzetas" );

        Arrays.stream(PajamuKategorija.values()).forEach(k -> {
            System.out.println(k);
            System.out.println(k.getKaterorija());
        });
    }
}
