package donnu.zolotarev.tpi.laba2;

import java.util.Collection;

public interface IFileFinder {

    public Collection<String> getFilesNames();
    public String getFileByName();
    public void deleteFileByName (Collection<String> strings);
    public void createFile (String fileName, String texts);

}
