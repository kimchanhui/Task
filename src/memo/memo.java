package memo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class memo {
    static Scanner scanner = new Scanner(System.in);

    private static void ShowMenuList() {
            System.out.println("=================");
            System.out.println("   1. 메모 쓰기   ");
            System.out.println("   2. 메모 읽기   ");
            System.out.println("   3. 메모 삭제   ");
            System.out.println("   4. 종료   ");
            System.out.println("=================");
    }

    private static void SelectMenu() {
        System.out.print("입력 : ");
        int selValue =  scanner.nextInt();

        CheckSelectValue(selValue);
    }

    private static void CheckSelectValue(int selValue) {
        if (selValue == 1) {
            System.out.println("[메모 쓰기]");

            WriteMemo();
        } else if (selValue == 2) {
            System.out.println("[메모 읽기]");

            ReadMemo();

            ReadFile();
        } else if (selValue == 3) {

        } else if (selValue == 4) {

        } else {
            return;
        }
    }

    private static void WriteMemo() {
        System.out.print("이름 : ");
        String name = scanner.next();

        System.out.print("중요도(A,B,C) : ");
        String severity = scanner.next();

        System.out.print("내용(exit = 입력종료) : ");
        String content = "";

        String text = name + "   " + severity;

        AppendText(text);
        while (true) {
            content = scanner.next();

            if (content.equals("exit")) {
                content = "======";
                AppendText(content);
                break;
            } else {
                AppendText(content);
            }
        }
    }

    static File file = new File("C:\\textFolder\\text.txt");

    private static void AppendText(String content) {
        String text = content;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(text);
            writer.newLine();

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadMemo() {
        System.out.println("[번호]  [이름]   [내용(일부분)]");
    }

    private static void ReadFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String list = "";

            for (int i = 0; i <= reader.readLine().length(); i++) {
                list += reader.readLine();
            }
            System.out.print(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        while (true){
            ShowMenuList();

            SelectMenu();

        }
    }
}
