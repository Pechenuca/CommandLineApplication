package mainPackage;

import Source.Organization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class FileReader {
    File file = new File("server/src/file/file.xml");

    public FileReader() {
    }

    public ArrayList<Organization> read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<Organization> organizations = new ArrayList<Organization>();
        try {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("!");
            scanner.close();

        }


        return organizations;
    }
}

