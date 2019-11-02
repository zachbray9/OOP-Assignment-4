import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException {
        FileInputStream fileByteStreamIn = new FileInputStream(dataFile);
        Scanner inFS = new Scanner(fileByteStreamIn);
        String tempWord = "";

        while (inFS.hasNext()) {
            tempWord = inFS.next();

            if (wordCounter.containsKey(tempWord)) {
                wordCounter.put(tempWord, wordCounter.get(tempWord) + 1);
            } else {
                wordCounter.put(tempWord, 1);
            }
        }
        fileByteStreamIn.close();
    }


    public void write(String outputFile) throws IOException {
        FileOutputStream fileByteStreamOut = new FileOutputStream(outputFile);
        PrintWriter outFS = new PrintWriter(fileByteStreamOut);

        Iterator itr = wordCounter.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            String value = wordCounter.get(key).toString();

            outFS.println(key + ": " + value);
        }

        outFS.flush();
        fileByteStreamOut.close();
    }


}
