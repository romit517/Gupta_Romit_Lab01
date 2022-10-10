public class ProductGenerator {

    private String name;

    private String description;

    private String ID;  //should never change

    double cost = 0.0;


    private static int seedID = 0;


    public ProductGenerator(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }


    public ProductGenerator(String name, String description, double cost) {
        seedID++;
        this.name = name;
        this.description = description;
        this.ID = "00000" + seedID;
        this.cost = cost;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product Information:{" +
                "Name='" + name + '\'' +
                ", Description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", Cost=" + cost +
                '}';
    }

    public String toCSVDataRecord(){
        String val = ID + "," +
                name + "," +
                description + "," +
                cost + ", ";

        return val;
    }

    public String fullDesc(){
        String val = name + " " +
                description + " " +
                cost + ".";

        return val;
    }

}
