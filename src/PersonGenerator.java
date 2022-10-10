public class PersonGenerator {

        private String ID = "";
        private String firstName = "";
        private String lastName = "";
        private String title = "";
        private int yearOfBirth = 0;




    public PersonGenerator(String ID, String firstName, String lastName, String title, int yearOfBirth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    @Override
    public String toString() {
        return
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public String toCSVDataRecord()
    {
        String val = ID + "," +
                firstName +"," +
                lastName + "," +
                title + "," +
                yearOfBirth + ", ";
        return val;
    }

    //Test Method 1
    public String fullName(){
        String val = firstName + " " +
                lastName;

        return val;
    }

    //Test Method 2
    public String formalName(){
        String val = title + " " +
                firstName + " " +
                lastName;

        return val;
    }

    //Test Method 3
    public String getAge()
    {
        String age = String.valueOf(yearOfBirth);
        return age;
    }



}