package memo;

import java.util.Scanner;

public class Menu {

    public Menu() {
        ShowMenu();
        SelectMenu();
    }

    private void ShowMenu() {
        System.out.println("=================");
        System.out.println("   1. 메모 쓰기   ");
        System.out.println("   2. 메모 읽기   ");
        System.out.println("   3. 메모 삭제   ");
        System.out.println("   4. 종료   ");
        System.out.println("=================");
    }

    private void SelectMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력 : ");
        int selValue =  scanner.nextInt();

        CheckSelectMenu(selValue);
    }

    private void CheckSelectMenu(int value) {
        if (value == 1) {
            System.out.println("[메모 쓰기]");

            WriteMemo writeMemo = new WriteMemo();
        } else if (value == 2) {
            System.out.println("[메모 읽기]");


        } else if (value == 3) {

        } else if (value == 4) {

        }
    }
}
