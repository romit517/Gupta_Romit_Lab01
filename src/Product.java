import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;


public class Product {

    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);

        boolean done = false;
        ArrayList<ProductGenerator> listOfProducts = new ArrayList<>();
        String ID = "";
        String name = "";
        String desc = "";
        double cost = 0;

        int counter = 1;
        do {

            System.out.println("Please provide the person information below: (ENTRY NO - " + counter + ")");
            System.out.println("================================================");

            name = SafeInput.getNonZeroLenString(pipe,"What is the name of your product?");
            desc = SafeInput.getNonZeroLenString(pipe,"Please write a description of the product");
            cost = SafeInput.getDouble(pipe,"What is the cost?");

            ProductGenerator P = new ProductGenerator(name, desc, cost);
            listOfProducts.add(P);

            done = SafeInput.getYNConfirm(pipe, "Are you finished? ");
            counter++;

        }while(!done);

        String nameOfFile;

        nameOfFile = SafeInput.getNonZeroLenString(pipe, "Please provide a filename to save these records into: ");
        nameOfFile += ".txt";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\"+nameOfFile);

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(ProductGenerator recs : listOfProducts)
            {
                writer.write(recs.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("data file written");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

