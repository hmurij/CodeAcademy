package lt.codeacademy;


import lt.codeacademy.model.Azuolas;
import lt.codeacademy.model.Berzas;
import lt.codeacademy.model.Egle;
import lt.codeacademy.model.Kadagys;
import lt.codeacademy.model.Medis;
import lt.codeacademy.model.Pusis;
import lt.codeacademy.model.Spygliuotis;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Berzas berzas = new Berzas();
        Azuolas azuolas = new Azuolas();
        Egle egle = new Egle();
        Pusis pusis = new Pusis();
        Kadagys kadagys = new Kadagys();

        ivairusMiskas(List.of(berzas, azuolas, egle, pusis, kadagys));

        spygliuociuMiskas(List.of(egle, pusis, kadagys));

        berzuMiskas(List.of(berzas, new Berzas(), new Berzas()));
    }

    public static <T extends Medis> void ivairusMiskas(List<T> trees) {
        System.out.println("Ivairus miskas:");
        trees.forEach(Medis::turi);
        System.out.println();
    }

    public static <T extends Spygliuotis> void spygliuociuMiskas(List<T> trees) {
        System.out.println("Spygliuociu miskas:");
        trees.forEach(Medis::turi);
        System.out.println();
    }

    public static void berzuMiskas(List<Berzas> trees) {
        System.out.println("Berziu miskas");
        trees.forEach(Medis::turi);
        System.out.println();
    }

    public static void printTrees(List<? extends Spygliuotis> trees) {

    }


}
