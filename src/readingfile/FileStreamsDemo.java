package readingfile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamsDemo {

    public static void main(String[] args) {

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("input.txt");
            fileWriter = new FileWriter("output.txt");

            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }
            System.out.println("Text file copied Successfully using character streams");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                if (fileWriter != null)
                    try {
                        fileReader.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }


        }
    }
}
