package Application.command;

import Application.ArgException;
import Application.CommandManager;
import Application.ConsoleCommands;

import java.util.Collection;
import java.util.HashMap;

public class RemoveCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public RemoveCommand(ConsoleCommands consoleCommands){
        setDescription("удалить элемент из коллекции по его id");
        setArgs(" id");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        try {
            consoleCommands.remove_by_id((Application.Collection) collection, Integer.parseInt(arg[0]));
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new ArgException();
        }
    }
}