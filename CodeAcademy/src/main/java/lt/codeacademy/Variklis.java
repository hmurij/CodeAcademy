package lt.codeacademy;

public class Variklis {
    protected String fuelType;
    protected double weight;

    double height;
    double width;

    public int numberOfCylinders;
    public double displacement;

    {
        fuelType = "Diesel";
        weight = 0;

        height = 0;
        width = 0;

        numberOfCylinders = 6;
        displacement = 3.0;
    }

    protected void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    void setHeight(double height) {
        this.height = height;
    }

    void setWidth(double width) {
        this.width = width;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }
}
