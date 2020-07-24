package Source;

import exception.FieldException;

import javax.xml.bind.JAXBException;
import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private OrganizationType type; //Поле не может быть null
    private Address officialAddress; //Поле не может быть null

    public Organization(int id, String name, Double x, long y, Coordinates coordinates, ZonedDateTime creationDate, Long annualTurnover, String fullName, OrganizationType type, Address officialAddress) throws JAXBException {
        this.id = id;
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        this.creationDate = ZonedDateTime.now();
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.type = type;
        this.officialAddress = new Address();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    public int getId() {
        if(id<0) throw new FieldException();
        else return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public String getAnnualTurnover() {
        if(annualTurnover == 0 || annualTurnover.toString().equals("")) throw new FieldException();
        else return annualTurnover.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public OrganizationType getType() {
        return type;
    }

    public int getOfficialAddress() {
        int officialAddress_in_integer = Integer.parseInt(String.valueOf(officialAddress));
        if(officialAddress_in_integer < 0 ) throw new FieldException();
        else return officialAddress_in_integer;
    }

    @Override
    public int compareTo(Organization o) {
        return 0;
    }

    /*public void XmlOrgParse() {
        try {
            File orgFile = new File("file");
            JAXBContext orgContext = JAXBContext.newInstance(Source.Organization.class);

            Unmarshaller orgUnmarshaller = orgContext.createUnmarshaller();
            Source.Organization org = (Source.Organization) orgUnmarshaller.unmarshal(orgFile);
            System.out.println(org);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

     */


}


