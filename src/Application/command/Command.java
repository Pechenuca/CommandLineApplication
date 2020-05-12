package Application.command;

import Application.CommandManager;

import javax.activation.CommandMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;


public class Command {
    private String description;
    private String args = "";

    public void execute(HashMap<String, Command> hashMap, Collection collection, CommandManager commandManager, String... arg) {

    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
