package Application.command;

import Application.ArgException;
import Application.CommandManager;
import Application.ConsoleCommands;

import java.util.Collection;
import java.util.HashMap;

public class SaveCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public SaveCommand(ConsoleCommands consoleCommands) {
        setDescription("сохранить коллекцию в файл");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length > 0) throw new ArgException();
        else {
            consoleCommands.save(collection);
        }
    }
}