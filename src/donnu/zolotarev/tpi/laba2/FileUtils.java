package donnu.zolotarev.tpi.laba2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileUtils {

    public static final String DIR_NAME = "GPSApp";
    public static final String SAVED_FILE_EXT = ".gsf";

    public static void delete(String f){
        new File(f).delete();
    }

    public static void writeFile(String fileName, String text){
        try{
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        }catch(Exception e) {
            System.out.println("Ошибка при работе с файлом!");
        }
    }

    public static String readFile(String fileName){
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        if(file.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                }finally {
                    in.close();
                }
            }catch (Exception e) {
                System.out.println("Ошибка при работе с файлом!");
            }
        }
        return sb.toString();
    }

    public static void mkDir(String dirPath){
       new File(dirPath).mkdir();
    }

}
