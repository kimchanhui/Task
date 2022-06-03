package memo;

import java.io.*;
import java.util.Scanner;

public class ReadMemo {
    public ReadMemo(int selValue) {
        ShowFileList(selValue);

    }

    private void ShowFileList(int selValue) {
        File dir = new File("C:\\textFolder\\");

        File[] fileList = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith("txt");
            }
        });

        for (int i = 0; i < fileList.length; i++) {
            System.out.print("  " + (i + 1) + " | " + fileList[i].getName() + " | ");
            ReadListFile("C:\\textFolder\\" + fileList[i].getName());
        }

        if (fileList.length == 0) {
            System.out.println("파일이 없습니다.");
        }

        if (selValue == 2) {
            ReadFile(fileList, SelectFile());
        } else if (selValue == 3) {
            DeleteFile(fileList, SelectFile());
        }
    }

    private void ReadListFile(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( new FileReader(fileName));

            String data;
            while((data = bufferedReader.readLine()) != null) {
                if (!data.contains("중요도 :") && !data.contains("날짜 :")) {
                    System.out.println(data.substring(0,5));
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void DeleteFile(File[] fileList, int i) {
        if(fileList[i-1].delete()){
            System.out.println("파일삭제 성공");
        }
    }

    private void ReadFile(File[] fileList, int i) {
        try {
            Scanner scanner = new Scanner(fileList[i-1]);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int SelectFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호 선택 : ");

        int selValue = scanner.nextInt();

        return selValue;
    }
}
