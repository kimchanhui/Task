public class NumberObjects {
    public static void main(String[] args) {
        NumberObjects sample = new NumberObjects();

        sample.parseLong("r1234");
        sample.parseLong("1234");
        sample.printOtherBase(1234);
    }

    public long parseLong(String data) {
        long retLong = -1;
        try {
            retLong = Long.parseLong(data);
            System.out.println(retLong);
        } catch (NumberFormatException ne) {
            System.out.println(data + " is not a number");
        } catch (Exception e){

        }

        return retLong;
    }

    public void printOtherBase(long value) {
        System.out.println("Original : " + value);
        System.out.println("Binary   : " + Long.toBinaryString(value));
        System.out.println("Hex      : " + Long.toHexString(value));
        System.out.println("Octal    : " + Long.toOctalString(value));
    }

}
