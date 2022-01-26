package lt.codeacademy;

public class Ratas {
    protected double radius;
    protected double width;

    double weight;
    boolean isNew;

    public String rubberType;
    public double price;

    {
        radius = 0;
        width = 0;

        weight = 0;
        isNew = false;

        rubberType = "MS";
        price = 0;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setRubberType(String rubberType) {
        this.rubberType = rubberType;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
