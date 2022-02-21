package lt.codeacademy.task1;

public class StartUp implements Starter {
    @Override
    public String start(String startupName, String founderName) {
        return startupName + " - " + founderName;
    }

    public static void main(String[] args) {
        Starter starter = new StartUp();
        System.out.println(starter.start("Some start up", "John Doe"));
        starter.progress();
        System.out.println(Starter.finish());
    }
}
