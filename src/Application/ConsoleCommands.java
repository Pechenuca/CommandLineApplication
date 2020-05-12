package Application;

import Application.command.Command;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

public class ConsoleCommands {
    public void help(HashMap<String, Command> commandHashMap) {
        System.out.println("Справка:");
        for (Map.Entry<String, Command> entry : commandHashMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().getArgs() + ": " + entry.getValue().getDescription());
        }
    }
    public void exit() {
        System.out.println("Таки до новых встреч!");
    }

    public void add(Collection collection) throws JAXBException {
        collection.add();
    }

    public void info(Collection collection) {
        System.out.println(collection.getInfo());
    }

    public void show(Collection collection) {
        collection.show();
    }

    public void remove_by_id(Collection collection, int id) {
        collection.remove_by_id(id);
    }

    public void update(Collection collection, int id) throws JAXBException {
        collection.replace(id);
    }

    public void clear(Collection collection) {
        collection.clear();
    }
    public void remove_first(Collection collection) {
        collection.remove_first();
    }

    public void count_greater_than_official_address() {

    }

    public void remove_grater(Collection collection) throws JAXBException {
        collection.remove_greater();
    }
}
