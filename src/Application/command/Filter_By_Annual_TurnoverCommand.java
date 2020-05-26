package Application.command;

import Application.ArgException;
import Application.Collection;
import Application.CommandManager;
import Application.ConsoleCommands;

import java.util.HashMap;

public class Filter_By_Annual_TurnoverCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public Filter_By_Annual_TurnoverCommand(ConsoleCommands consoleCommands) {
        setDescription("вывести элементы, значение поля name которых содержит заданную подстроку");
        setArgs(" name");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length != 1) throw new ArgException();
        else {
            consoleCommands.filterTurnover(collection,arg[0]);
        }
    }
}
