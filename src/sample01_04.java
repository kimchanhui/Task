import java.util.Scanner;

public class sample01_04 {
    private static String result_1 = "";
    private static String result_2 = "";

    private static int Scanner() {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        return a;

    }

    private static void Run() {
        int num = Scanner();

        for (int i = 0; i < num; i++){
            WriteValue();
        }

        ShowResults();
    }

    private static void WriteValue() {
        int num = Scanner();

        CheckValue(num);
    }

    private static void CheckValue(int num) {
        if (num % 2 == 0) {
            result_1 = result_1 + String.valueOf(num) + " ";
        } else {
            result_2 = result_2 + String.valueOf(num) + " ";
        }

    }

    private static void ShowResults() {
        System.out.println("짝수 : " + result_1);
        System.out.println("홀수 : " + result_2);
    }


    public static void main(String[] args) {
        Run();
    }

}
