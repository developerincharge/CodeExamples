package readingfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {


    public static void main(String[] args) {

         BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("input.txt"));
            writer.write("Hello, Syed and it is a test file");
            writer.newLine();
            writer.write("This is another line in file");
            System.out.println("data written to files successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null) try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
