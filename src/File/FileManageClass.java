package File;

import java.io.File;
import java.io.IOException;

public class FileManageClass {
     public static void main(String[] args) {
          FileManageClass sample = new FileManageClass();
          String pathName = File.separator + "javaTxt" + File.separator + "text";
          String fileName = "text.txt";

          sample.checkFile(pathName, fileName);
     }

     public void checkFile(String pathName, String fileName){
          File file = new File(pathName, fileName);
          try {
               System.out.println("create result = " + file.createNewFile());
               getFileInfo(file);
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public void getFileInfo(File file) throws IOException {
          System.out.println("Ab path = " + file.getAbsolutePath());
          System.out.println("Ab file = " + file.getAbsoluteFile());
          System.out.println("Can path = " + file.getCanonicalPath());
          System.out.println("Can file = " + file.getCanonicalFile());

          System.out.println("Name = " + file.getName());
          System.out.println("Path = " + file.getPath());
     }
}
