import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Person {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);



        boolean done = false;
        ArrayList<PersonGenerator> listOfPersons = new ArrayList<>();
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;

        int counter = 1;


        do {

            System.out.println("Please provide the person information below: (ENTRY NO - " + counter + ")");
            System.out.println("================================================");

            ID = SafeInput.getNonZeroLenString(in, "What is your ID Number: "); //IDNum is handled with the help of our static class variable "seed".
            firstName = SafeInput.getNonZeroLenString(in, "What is your First Name: ");
            lastName = SafeInput.getNonZeroLenString(in,"What is your Last Name?");
            title = SafeInput.getNonZeroLenString(in,"What is your Title Name?");
            yearOfBirth = SafeInput.getRangedInt(in,"What is your Year of Birth?", 1940, 2000);

            PersonGenerator P = new PersonGenerator(ID,firstName, lastName, title, yearOfBirth);
            listOfPersons.add(P);

            done = SafeInput.getYNConfirm(in, "Are you finished? ");
            counter++;
        }while (!done);

        String nameOfFile;

        nameOfFile = SafeInput.getNonZeroLenString(in, "Please provide a filename to save these records into: ");
        nameOfFile += ".txt";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\"+nameOfFile);



        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));


            for (PersonGenerator recs : listOfPersons)
            {
                writer.write(recs.toCSVDataRecord());           //Here, toCSVDataRecord is a method that returns our comma-separated list of entries to the writer.
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file successfully written...");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Displaying the records for debugging purposes only.


        /*
        for(PersonGenerator recs : listOfPersons)
        {
            System.out.println(recs.toCSVDataRecord());
            System.out.println("");
        }
        */





    }

}
