package lt.codeacademy.exercise.menu;

/**
 * Every menu's in application should use this interface
 *
 * @author pavel.vrublevskij
 * @version 1.0
 * @since 2022-02-01
 */
public interface Menu {

    /**
     * Method should render/generate a menu which should be visible for customer(s)
     */
    void generateMenu();
}
