package lt.codeacademy.model;

public abstract class Medis {
    public void turi() {
        System.out.println(getClass().getSimpleName() + " turi "
//                + (Lapuotis.class.isInstance(this) ? "lapus" : "spyglius"));
                + (this instanceof Lapuotis ? "lapus" : "spyglius"));
    }
}
