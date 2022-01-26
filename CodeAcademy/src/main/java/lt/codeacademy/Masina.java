package lt.codeacademy;

import lt.codeacademy.interior.Wheel;

public class Masina {
    protected Variklis variklis;
    protected Ratas frontLeft;
    protected Ratas frontRight;
    protected Ratas rearLeft;
    protected Ratas rearRight;

    private Wheel wheel;

    String color;
    String numberOfDoors;

    public double width;
    public double height;

    {
        variklis = new Variklis();
        variklis.displacement = 3.0;
        frontLeft = new Ratas();
        frontLeft.price = 100.0;
        frontRight = new Ratas();
        frontLeft.setNew(true);
        rearLeft = new Ratas();
        rearLeft.radius = 255;
        rearRight = new Ratas();
        rearRight.setRubberType("M");

        wheel = new Wheel();

    }

    protected void setVariklis(Variklis variklis) {
        this.variklis = variklis;
    }

    protected void setFrontLeft(Ratas frontLeft) {
        this.frontLeft = frontLeft;
    }
    protected void setFrontRight(Ratas frontRight) {
        this.frontRight = frontRight;
    }

    protected void setRearLeft(Ratas rearLeft) {
        this.rearLeft = rearLeft;
    }

    protected void setRearRight(Ratas rearRight) {
        this.rearRight = rearRight;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
