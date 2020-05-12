package Application;

import Application.Address;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.util.Vector;

public class Collection {
    private Vector<Organization> vectorOrg = new Vector<Organization>();
    private ZonedDateTime creationTime;
    private Factory factory = new Factory();
    private int countOfOrg;
    private String type = getCollection().getClass().getTypeName();

    public Vector<Organization> getVector() {
        return vectorOrg;
    }

    Vector<Organization> collection = new Vector<Organization>();

    //private String type =
    Collection(File file) throws FileNotFoundException {
        String fileName = "file";
        Path path = Path.get(fileName);
        try {
            // LinkedHashSet<Organization> collection1 = Scanner(file);
            collection.addAll(collection1);
        } catch (FileException e) {
            System.out.println(e.getMessage());
        }
    }
        /*Scanner scanner = new Scanner(file);

        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()) {
            vectorOrg.addAll()

        }


    }
    */


    public void add() throws JAXBException {
        Organization organization = factory.createOrganization();
        getVector().add(organization);
    }

    public boolean addIfMax() throws JAXBException, JAXBException {
        Organization organization = factory.createOrganization();
        if (isMax(organization)) {
            getVector().add(organization);
            return true;

        } else {
            return false;
        }
    }

    public boolean isMax(Organization organization) {
        boolean i = true;
        for (Organization organization1 : vectorOrg) {
            if (organization.compareTo(organization1) <= 0) {
                i = false;
                break;
            }
        }
        return i;
    }

    public void show() {
        if (!getVector().isEmpty()) {
            int i = 1;
            for (Organization organization : vectorOrg) {
                System.out.println("Организация " + i);
                System.out.println(organization.toString());
                i++;
            }

        } else {
            System.out.println("Коллекция пуста");
        }
    }

    public void remove_by_id(int id) {
        if (!getVector().isEmpty()) {


            for (Organization organization : vectorOrg) {
                if (organization.getId() == id) {
                    IdGenerator.remove(organization.getId());
                    vectorOrg.remove(organization);
                    System.out.println("Организация удалена");
                    return;
                }
            }
            System.out.println("Организация с данным id не найдена");
        }
        System.out.println("Коллекция пуста");
    }

    public void clear() {
        countOfOrg -= collection.size();
        collection.clear();
        IdGenerator.clear();
    }

    public void remove_first() {
        if (!getVector().isEmpty()) {
            vectorOrg.remove(1);
        } else {
            System.out.println("коллекция пуста");
        }
    }

    public void remove_greater() throws JAXBException {
        if (!getVector().isEmpty()) {
            Organization newOrganization = factory.createOrganization();
            Vector<Organization> vector1 = new Vector<Organization>();
            IdGenerator.clear();
            vectorOrg.forEach(organization -> {
                if (newOrganization.compareTo(organization) >= 0) {
                    vector1.add(organization);
                    IdGenerator.push(organization.getId());
                }
            });
            vectorOrg = vector1;
        }
    }

    public String getInfo() {
        return "Информация о коллекции \n" + "Дата инициализации коллекции: " + getCreationTime() + "\n Тип коллекции: " +

    }

    public void count_greater_than_official_address(Address address1, String arg) {
        try {


        } catch (NumberFormat)

        return vectorOrg.stream().filter(organization -> organization.getStreet()) > address1.count();

    }

    public void replace(int id) throws JAXBException {
        if (!getCollection().isEmpty()) {
            for (Organization organization : getCollection()) {
                collection.remove(organization);
                Organization newOrg = factory.createOrganization();
                newOrg.setId(id);
                collection.add(newOrg);
                System.out.println("Организация создана");
                break;
            }

        } else {
            System.out.println("организация с таким id не найдена");
        }

    }

    public void save() {
        try {

        }
    }

    public void setVector(Vector<Organization> vector) {
        this.vectorOrg = vector;
    }

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(ZonedDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public File getFile() {
        return file;
    }

    public String getType() {
        return type;
    }

    public Vector<Organization> getCollection() {
        return collection;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

