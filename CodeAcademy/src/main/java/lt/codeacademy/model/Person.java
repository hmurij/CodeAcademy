package lt.codeacademy.model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private double receivedMoney;
    private double sentMoney;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.receivedMoney = 0;
        this.sentMoney = 0;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void updateReceivedMoney(double amount){
        this.receivedMoney += amount;
    }

    public void updateSendMoney(double amount) {
        this.sentMoney += amount;
    }

    public double getReceivedMoney() {
        return receivedMoney;
    }

    public double getSentMoney() {
        return sentMoney;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", receivedMoney=" + receivedMoney +
                ", sentMoney=" + sentMoney +
                '}';
    }
}
