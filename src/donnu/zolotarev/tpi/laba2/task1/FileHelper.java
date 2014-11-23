package donnu.zolotarev.tpi.laba2.task1;

import donnu.zolotarev.tpi.laba2.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FileHelper implements IFileFinder {


    private File dir;

    @Override
    public void setDirPath(String dirPath) {
        dir =  new File(dirPath);
        if (!dir.isDirectory()){
           throw new IllegalArgumentException(dirPath +"Is not directory");
        }
    }

    @Override
    public Collection<String> getFilesNames() {
        LinkedList<String> strings = new LinkedList<String>();
        List<File> fileList = Arrays.asList(dir.listFiles());
        for (File f: fileList){
            if (f.isFile()){
                strings.add(f.getName());
            }
        }
        return strings;
    }

    @Override
    public String getFileBodyByName(String name) {
        return FileUtils.readFile(getPathToFile(name));
    }

    @Override
    public void deleteFilesByName(Collection<String> strings) {
         for (String s:strings){
             FileUtils.delete(getPathToFile(s));
         }
    }


    @Override
    public void createFile(String fileName, String texts) {
        FileUtils.writeFile(getPathToFile(fileName),texts);
    }

    private String getPathToFile(String name){
        String s = dir.getAbsolutePath();
        if (!s.isEmpty()){
            return dir.getAbsolutePath()+File.separator+name;
        }else{
            return name;
        }
    }
}
