package lt.codeacademy.task2;

import lt.codeacademy.task3.Starter;

public class Task2 {
    public static void main(String[] args) {
        lt.codeacademy.task3.Starter starter = new lt.codeacademy.task3.Starter() {
            @Override
            public String start(String startupName, String founderName) {
                return startupName + " : " + founderName;
            }
        };

        System.out.println(starter.start("Some start up", "John Doe"));
        starter.progress();
        System.out.println(Starter.finish());
    }
}
