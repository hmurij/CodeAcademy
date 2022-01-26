package lt.codeacademy.interior;

public class Wheel {
    public double size;
    boolean isLeather;
    protected double weight;

    {
        size = 0;
        isLeather = false;
        weight = 1.5;
    }

    public void setSize(double size) {
        this.size = size;
    }

    void setLeather(boolean leather) {
        isLeather = leather;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }
}
