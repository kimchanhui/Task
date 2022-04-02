import java.util.Scanner;

public class sample01_05 {

    static Scanner scanner = new Scanner(System.in);

    private static void Scanner() {
        String value_1 =  scanner.next();
        String value_2 =  scanner.next();

        System.out.print(value_1 + " " + value_2);
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner();
    }

}
