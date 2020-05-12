package Application;

import Application.command.Command;

import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, Command> commandHashMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandHashMap.put(commandName, command);

    }

    public void execute(String commandName, HashMap<String, Command> commandHashMap, Collection collection, String... args) {
        Command command = commandHashMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException(commandName + " -- такой команды нет");

        }
        command.execute(commandHashMap, (java.util.Collection) collection, this, args);
    }

    public HashMap<String, Command> getCommandHashMap() {
        return commandHashMap;
    }


}

