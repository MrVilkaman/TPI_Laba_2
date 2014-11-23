package donnu.zolotarev.tpi.laba2;

import java.util.Collection;
import java.util.LinkedList;

public class SystemFileExplorer {

    public final static String explorer = ".tmp";
    public final static String defaultName = "backup";

    private final IFileFinder fileFinder;


    public SystemFileExplorer(IFileFinder fileFinder) {
        this.fileFinder = fileFinder;
    }

    public void mergeTemporaryFiles( String dir ){
        Collection<String> files =  getFileWithExp(fileFinder.getFilesNames(),explorer);

        if (files != null){
            fileFinder.createFile(defaultName+explorer,createBackup(files));
            fileFinder.deleteFileByName(files);
        }
    }

    public String createBackup(Collection<String> files) {
        StringBuilder builder =  new StringBuilder();
        for (String name :files){
            builder.append(fileFinder.getFileByName(name));
        }
        return builder.toString();
    }

    public Collection<String>  getFileWithExp(Collection<String> filesAll,String exp){
        LinkedList<String> strings =  new LinkedList<String>();
        for (String s: filesAll){
            if (s.contains(exp)){
                strings.add(s);
            }
        }
         return strings;
    }
}
