package lt.codeacademy.task3;

public class Task3 {
    public static void main(String[] args) {
        Starter starter = (startupName, founderName) -> startupName + " : " + founderName;

        System.out.println(starter.start("Some start up", "John Doe"));
        starter.progress();
        System.out.println(Starter.finish());
    }
}
