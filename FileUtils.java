package datastructures;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vijaya on 3/9/2017.
 */
public class FileUtils {

    public static String findFile(String filename, String path) {
            File pathFile = new File(path);
            String retValue = "";
            File[] files1 = pathFile.listFiles();
            for (int i = 0; i < files1.length; i++) {
               File fileinList = files1[i];
                if (fileinList.isDirectory()) {
                    retValue = retValue + "\n" + findFile(filename, path + "\\" + fileinList.getName());
                }
                else
                     if (filename.equalsIgnoreCase(fileinList.getName())) {
                       retValue = retValue + "\n" + path + "\\" + fileinList.getName();
                     }
                }

            return retValue;
        }

    public static void main(String[] args) {
        System.out.println("retValue =  " + FileUtils.findFile("foo.txt","C:\\vijaya"));
    }

}
