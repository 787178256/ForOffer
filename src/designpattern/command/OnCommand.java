package designpattern.command;

/**
 * Created by kimvra on 2019-02-23
 */
public class OnCommand implements Command{

    private Light light;

    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
