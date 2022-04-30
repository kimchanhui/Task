package Test_1;
import java.util.Scanner;

public class Alphabet {


    public static void Alphabet() {
            Scanner s = new Scanner(System.in);
            String str[] = s.next().toUpperCase().split("");
            int cnt[] = new int[26];
            int max = 0;
            String result = "";

            for (int i = 0; i < str.length; i++) {
                int ch = str[i].charAt(0)-65;
                cnt[ch]++;

                if (max < cnt[ch]) {
                    max = cnt[ch];
                    result = str[i];
                }
                else if (max == cnt[ch]) {
                    result = "";
                }
            }
            System.out.print(result);
    }

    public static void main(String[] args) {
        Alphabet();
    }
}
