package memo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WriteMemo {
    Scanner scanner = new Scanner(System.in);

    public WriteMemo() {
        CreateFile();
    }

    private String GetDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date();
        return format.format(date);
    }

    private String WriteText() {
        System.out.print("메모 중요도 입력 : ");
        String severity = scanner.next();

        System.out.print("메모 내용 입력 : ");

        boolean loop = true;
        String content = "";

        StringBuffer buffer = new StringBuffer();
        while (loop) {
            String text = scanner.nextLine();

            if(text.equals("exit")) {
                content = buffer.toString();

                loop = false;
            } else {
                buffer.append(text + "\n");
            }
        }

        String data = "중요도 : " + severity + "\n날짜 : " + GetDate() + " ." + content;

        return data;
    }

    private void CreateFile() {
        System.out.print("메모 이름 입력 : ");
        String fileName = scanner.nextLine();

        File file = new File("C:\\textFolder\\" + fileName + ".txt");

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));

            bufferedWriter.write(WriteText());
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
