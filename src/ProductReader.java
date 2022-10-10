import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;


public class ProductReader {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File chosenFile;
        String rec = "";

        ArrayList<ProductGenerator> presults = new ArrayList<>();
        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)

            {
                System.out.println("\n==========================================================================");
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
                    String name = detailed[1];
                    String desc = detailed[2];
                    double cost = Double.parseDouble(detailed[3]);

                    presults.add(new ProductGenerator(name, desc, id, cost));


                    //String[] splitValues = rec.split(", ");
                   // System.out.printf("\n%-15s%-20s%-30s%-30s", splitValues[0], splitValues[1], splitValues[2], splitValues[3]);
                }
                for(ProductGenerator p : presults)
                {
                    System.out.println(p);
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }

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
