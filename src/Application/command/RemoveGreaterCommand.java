package Application.command;

import Application.ArgException;
import Application.Collection;
import Application.CommandManager;
import Application.ConsoleCommands;

import java.util.HashMap;

public class RemoveGreaterCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public RemoveGreaterCommand(ConsoleCommands consoleCommands) {
        setDescription("удалить из коллекции все элементы, превышающие заданный");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length > 0) throw new ArgException();
        else {
            consoleCommands.removeGreater(collection);
        }
    }
}
