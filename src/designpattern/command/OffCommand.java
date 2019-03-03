package designpattern.command;

/**
 * Created by kimvra on 2019-02-23
 */
public class OffCommand implements Command{

    private Light light;

    public OffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
