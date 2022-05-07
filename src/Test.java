import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();

        ArrayList b = new ArrayList();

        a.add("aa");
        b.add("bb");

        b.addAll(a);

        System.out.println(a);
        System.out.println(b);
    }
}
