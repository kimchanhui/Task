import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class sample02_01 {
    static LinkedList<Integer> list = new LinkedList<Integer>();
    static Scanner scanner = new Scanner(System.in);

    public static void Input() {
        for(int i = 0; i < 5; i++) {
            int data = scanner.nextInt();
            list.add(data);
        }
    }

    private static void ShowGrade() {
        System.out.println(list);
        ConvertGradeToZero();
    }

    private static void ConvertGradeToZero() {
        list.set(0, 0);
        list.set(2, 0);
        list.set(4, 0);

        System.out.println(list);
    }

    private static void Run() {
        Input();
        ShowGrade();
    }


    public static void main(String[] args) {
        Run();
    }
}
