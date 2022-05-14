package File;

import java.io.File;

public class FileSample {

    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String pathName = "C:\\javaTestDir\\Text";
        sample.checkPath(pathName);
        sample.makeDir(pathName);
        sample.checkFileMethods(pathName);
        sample.canFileMethods(pathName);
    }

    public void checkPath(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + "=" + file.exists());
    }

    public void makeDir(String pathName) {
        File file = new File(pathName);
        System.out.println("Make " + pathName + " result = " + file.mkdir());
    }

    public void checkFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is Dir? = " + file.isDirectory());
        System.out.println(pathName + " is File? = " + file.isFile());
        System.out.println(pathName + " is hidden? = " + file.isHidden());
    }

    public void canFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " can read? = " + file.canRead());
        System.out.println(pathName + " can write? = " + file.canWrite());
        System.out.println(pathName + " can execute? = " + file.canExecute());
    }
}
