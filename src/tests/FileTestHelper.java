package tests;

import donnu.zolotarev.tpi.laba2.IFileFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileTestHelper implements IFileFinder {

    private List<String> strings;
    private boolean isUseGetFilesName = false;
    private boolean isUseDeleteFileByName = false;
    private boolean isUseCreateFile = false;
    private boolean useGetFileByName = false;


    public FileTestHelper() {
        strings =  new ArrayList<String>();
        strings.addAll(Arrays.asList("file.tmp", "file2.tmp", "file.txt"));
    }

    @Override
    public Collection<String> getFilesNames() {
        isUseGetFilesName = true;
        return strings;
    }

    @Override
    public String getFileByName(String name) {
        useGetFileByName = true;
        if (name.equals("1")){
            return "qwer";
        } else if (name.equals("2")){
            return "1234";
        }else {
            return "";
        }

    }

    @Override
    public void deleteFileByName(Collection<String> strings) {
        isUseDeleteFileByName = true;
        this.strings.clear();
        this.strings.add("file.txt");
    }

    @Override
    public void createFile(String fileName, String texts) {
        isUseCreateFile = true;
        strings.add("backup.tmp");
    }

    public boolean isUseGetFilesName() {
        return isUseGetFilesName;
    }

    public boolean isUseDeleteFileByName() {
        return isUseDeleteFileByName;
    }

    public boolean isUseCreateFile() {
        return isUseCreateFile;
    }

    public boolean isUseGetFileByName() {
        return useGetFileByName;
    }
}
