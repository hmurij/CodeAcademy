package lt.codeacademy.factory;

import lt.codeacademy.model.Biudzetas;
import lt.codeacademy.model.IslaiduIrasas;
import lt.codeacademy.model.PajamuIrasas;
import lt.codeacademy.type.AtsiskaitymoBudas;
import lt.codeacademy.type.IslaiduKategorija;
import lt.codeacademy.type.PajamuKategorija;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Factory class generated mock data for Biudzetas object
 */
public class BiudzetasFactory {

    /**
     * Creates new Biudzetas objects and populates it with generated data
     * @return biudzetas object with 10 records of IslaiduIrasas and PajamuIrasas objects
     */
    public static Biudzetas generateBiudzetasMockObject(){
        Biudzetas biudzetas = new Biudzetas();

        for (int i = 0; i < 10; i++) {
            biudzetas.pridetiIslaiduIrasa(generateIslaiduIrasas());
            biudzetas.pridetiPajamuIrasa(generatePajamuData());
        }

        return biudzetas;
    }


    /**
     * Generates random IslaiduIrasas object
     *
     * @return random IslaiduIrasas object
     */
    private static IslaiduIrasas generateIslaiduIrasas() {
        Random r = new Random();
        IslaiduKategorija[] kategorijas = IslaiduKategorija.values();
        AtsiskaitymoBudas[] atsiskaitymoBudas = AtsiskaitymoBudas.values();

        return new IslaiduIrasas(r.nextDouble() * 1000,
                LocalDateTime.now().minusDays(r.nextInt(365)).minusMinutes(r.nextInt(60 * 24)),
                kategorijas[r.nextInt(kategorijas.length)],
                atsiskaitymoBudas[r.nextInt(atsiskaitymoBudas.length)],
                generateComment());
    }

    /**
     * Generates random PajamuIrasas object
     *
     * @return random PajamuIrasas object
     */
    private static PajamuIrasas generatePajamuData() {
        Random r = new Random();
        PajamuKategorija[] kategorijas = PajamuKategorija.values();

        return new PajamuIrasas(r.nextDouble() * 1000,
                LocalDate.now().minusDays(r.nextInt(365)),
                kategorijas[r.nextInt(kategorijas.length)],
                r.nextBoolean(),
                generateComment());
    }

    /**
     * Generates random dummy text comment
     *
     * @return random dummy text comment
     */
    private static String generateComment() {
        String[] comments = {"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa." +
                "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetuer adipiscing.",
                "Lorem ipsum."};

        return comments[new Random().nextInt(comments.length)];
    }
}
