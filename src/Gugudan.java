import java.util.Scanner;

public class Gugudan {

    private static void Gugudan1(int i) {
        for (int j = 1; j <= i; j++) {
            for (int k = 1; k <= 9; k++) {
                System.out.println(j * k);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        Gugudan1(i);

        scanner.close();
    }
}
