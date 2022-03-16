package lt.codeacademy.type;

public enum ReceivedType implements Type{
    YES("Taip"),
    NO("Ne");

    private final String type;

    ReceivedType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
