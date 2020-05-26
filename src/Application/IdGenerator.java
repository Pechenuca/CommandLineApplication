package Application;

import java.util.Vector;

public class IdGenerator {
    private static Integer counter = 1;
    private static Vector<Integer> idSet = new Vector<>();

    public static int generate() throws OverflowException {
        while (idSet.contains(counter)) {
            if (counter == Integer.MAX_VALUE) {
                throw new OverflowException();
            }
            counter++;
        }
        push(counter);
        return counter;
    }

    public static void addAll(Vector<Integer> set) {
        idSet.addAll(set);
    }

    public static void remove(Integer id) {
        idSet.remove(id);
        counter = Math.min(id, counter);
    }

    public static void clear() {
        idSet.clear();
        counter = 1;
    }

    public static void push(Integer id) {
        idSet.add(id);
    }

    public static Vector<Integer> getIdSet() {
        return idSet;
    }
}
