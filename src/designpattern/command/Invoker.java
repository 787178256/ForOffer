package designpattern.command;

/**
 * Created by kimvra on 2019-02-23
 */
public class Invoker {

    private Command[] onCommands;
    private Command[] offCommands;
    private int slotNum = 7;

    public Invoker() {
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }

    public void setOnCommand(Command command, int slotNum) {
        this.onCommands[slotNum] = command;
    }

    public void setOffCommand(Command command, int slotNum) {
        this.offCommands[slotNum] = command;
    }

    public void onButton(int slotNum) {
        onCommands[slotNum].execute();
    }

    public void offButton(int slotNum) {
        offCommands[slotNum].execute();
    }
}
