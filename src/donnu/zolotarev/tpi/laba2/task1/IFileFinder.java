package donnu.zolotarev.tpi.laba2.task1;

import java.util.Collection;

public interface IFileFinder {

    public void setDirPath(String dirPath);
    public Collection<String> getFilesNames();
    public String getFileBodyByName(String name);
    public void deleteFilesByName(Collection<String> strings);
    public void createFile (String fileName, String texts);

}
