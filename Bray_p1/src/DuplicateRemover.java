import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DuplicateRemover {

    private HashSet<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) throws IOException {
        FileInputStream fileByteStreamIn = new FileInputStream(dataFile);
        Scanner inFS = new Scanner(fileByteStreamIn);
        String tempWord = "";

        while (inFS.hasNext()) {
            tempWord = inFS.next();
            if (uniqueWords.contains(tempWord)) {
                uniqueWords.remove(tempWord);
            } else {
                uniqueWords.add(tempWord);
            }
        }

        fileByteStreamIn.close();
    }


    public void write(String outputFile) throws IOException {
        FileOutputStream fileByteStreamOut = new FileOutputStream(outputFile);
        PrintWriter outFS = new PrintWriter(fileByteStreamOut);

        outFS.println(uniqueWords);

        outFS.flush();
        fileByteStreamOut.close();
    }


}
