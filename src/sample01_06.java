import java.util.Scanner;

public class sample01_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();

        System.out.println(a.length());
        System.out.println(a.substring(0, 1) + " " + a.substring(a.length() -1, a.length()));



    }
}
