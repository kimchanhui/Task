import java.util.Scanner;

public class sample01_07 {
    static Scanner scanner = new Scanner(System.in);

    private static void Run() {
        System.out.print("선택 : ");
        String input = scanner.nextLine();

        System.out.print("값 : ");
        String value = scanner.next();

        if(input.equals("짝수")) {
            ShowEven(value);
        } else if(input.equals("홀수")) {
            ShowOdd(value);
        }

    }

    private static void ShowOdd(String value) {
        for (int i = 0; i <= value.length(); i++) {
            if(i % 2 == 1) {
                System.out.print(value.charAt(i-1));
            }
        }
    }

    private static void ShowEven(String value) {
        for (int i = 0; i <= value.length(); i++) {
            if(i % 2 == 0) {
                System.out.print(value.substring(i, i+1));
            }
        }
    }

    public static void main(String[] args) {
        Run();

    }
}
