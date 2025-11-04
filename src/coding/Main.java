package coding;

import java.util.*;
import java.io.*;

class Outcome {
    public static int solve(List<Integer> a){
        Collections.sort(a);
        int setCount = 0;
        int i = 0;
        int n = a.size();
        
        while (i < n) {
            setCount++;
            int current = i;
            while (current < n - 1 && a.get(current + 1) - a.get(current) == 1) {
                current++;
            }
            i = current + 1;
        }
        return setCount;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Use a fixed output file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();
        String[] atempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(atempItems[i]);
            a.add(aItem);
        }

        int outcome = Outcome.solve(a);
        bufferedWriter.write(String.valueOf(outcome));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        
        System.out.println("Output written to output.txt: " + outcome);
    }
}