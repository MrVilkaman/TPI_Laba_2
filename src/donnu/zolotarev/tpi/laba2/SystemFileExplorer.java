package donnu.zolotarev.tpi.laba2;

import java.util.Collection;

public class SystemFileExplorer {

    public final static String explorer = ".tmp";
    public final static String defaultName = "backup";

    private final IFileFinder fileFinder;


    public SystemFileExplorer(IFileFinder fileFinder) {
        this.fileFinder = fileFinder;
    }

    public void mergeTemporaryFiles( String dir ){
        Collection<String> files =  getFileWithExp(fileFinder.getFilesNames(),explorer);

        fileFinder.createFile(defaultName+explorer,createBackup(files));

        fileFinder.deleteFileByName(files);
    }

    private String createBackup(Collection<String> files) {
        return "";
    }


    private void concatFiles(){

    }

    public Collection<String>  getFileWithExp(Collection<String> filesAll,String dir){
         return null;
    }
}
