package designpattern.command;

/**
 * Created by kimvra on 2019-02-23
 */
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Invoker invoker = new Invoker();

        Command onCommand = new OnCommand(light);
        invoker.setOnCommand(onCommand, 0);

        Command offCommand = new OffCommand(light);
        invoker.setOffCommand(offCommand, 0);

        invoker.onButton(0);
        invoker.offButton(0);
    }
}
