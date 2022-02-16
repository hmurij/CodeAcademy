package lt.codeacademy.model;

import java.io.Serializable;
import java.util.Arrays;

public class Biudzetas implements Serializable {
    private PajamuIrasas[] pajamuIrasai;
    private int pajamuIrasaiSize;

    private IslaiduIrasas[] islaiduIrasai;
    private int islaiduIrasaiSize;

    public Biudzetas() {
        pajamuIrasai = new PajamuIrasas[1];
        islaiduIrasai = new IslaiduIrasas[1];

        pajamuIrasaiSize = 0;
        islaiduIrasaiSize = 0;
    }

    /**
     * Add new pajamuIrasas object to pajamuIrasai array if pajamuIrasaiSize = pajamuIrasai.length
     * new pajamuIrasai array created of doubled size
     *
     * @param pajamuIrasas new PajamuIrasas object, null objects ignored
     */
    public void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas) {
        if (pajamuIrasaiSize == pajamuIrasai.length) {
            pajamuIrasai = Arrays.copyOf(pajamuIrasai, pajamuIrasai.length * 2);
        }

        if (pajamuIrasas != null) {
            pajamuIrasai[pajamuIrasaiSize] = pajamuIrasas;
            pajamuIrasaiSize++;
        }
    }

    /**
     * Returns filled up part of pajamuIrasai array
     *
     * @return part or complete pajamuIrasai array
     */
    public PajamuIrasas[] gautiPajamuIrasus() {
        return Arrays.copyOf(pajamuIrasai, pajamuIrasaiSize);
    }

    /**
     * Add new islaiduIrasas object to islaiduIrasai array if islaiduIrasaiSize = islaiduIrasai.length
     * new islaiduIrasai array created of doubled size
     *
     * @param islaiduIrasas new IslaiduIrasas object, null objects ignored
     */
    public void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas) {
        if (islaiduIrasaiSize == islaiduIrasai.length) {
            islaiduIrasai = Arrays.copyOf(islaiduIrasai, islaiduIrasai.length * 2);
        }

        if (islaiduIrasas != null) {
            islaiduIrasai[islaiduIrasaiSize] = islaiduIrasas;
            islaiduIrasaiSize++;
        }
    }

    /**
     * Returns filled up part of pajamuIrasai array
     *
     * @return part or complete pajamuIrasai array
     */
    public IslaiduIrasas[] gautiIslaiduIrasa() {
        return Arrays.copyOf(islaiduIrasai, islaiduIrasaiSize);
    }

}