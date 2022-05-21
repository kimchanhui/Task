package memo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeMemo {
    public void CreateFile(String content) {
        File file = new File("C:\\textFolder\\text.txt");
        String text = content;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(text);
            writer.newLine();
            writer.write("=====");
            writer.newLine();

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
