package lt.codeacademy.truck;

import lt.codeacademy.Masina;
import lt.codeacademy.Ratas;
import lt.codeacademy.Variklis;
import lt.codeacademy.interior.Wheel;



public class Truck extends Masina {
    public Wheel wheel;


    {
        this.setFrontLeft(new Ratas());
        this.setVariklis(new Variklis());
        variklis.numberOfCylinders = 12;

        wheel.size = 45.0;
    }
}
