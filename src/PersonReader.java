import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;



public class PersonReader {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File chosenFile;
        ArrayList<PersonGenerator> results = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("\n===============================================================================");
                chosenFile = chooser.getSelectedFile();
                Path file = chosenFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                String currentLine;

                while((currentLine = reader.readLine()) !=null)
                {

                    String[] detailed = currentLine.split(",");
                    String id = detailed[0];
                    String fName = detailed[1];
                    String lName = detailed[2];
                    String title = detailed[3];
                    int yOb = Integer.parseInt(detailed[4]);

                    results.add(new PersonGenerator(id, fName, lName, title, yOb));
                }
                reader.close(); // must close the file to seal it and flush buffer

            }

            for(PersonGenerator p : results)
            {
                System.out.println(p);
            }
            System.out.println("\n\nData file read!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
