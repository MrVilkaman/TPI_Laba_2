package donnu.zolotarev.tpi.laba2;

import donnu.zolotarev.tpi.laba2.task1.FileHelper;
import donnu.zolotarev.tpi.laba2.task1.SystemFileExplorer;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("!!!");
           return;
        }else{
            FileHelper fileHelper = new FileHelper();
            SystemFileExplorer explorer = new SystemFileExplorer(fileHelper);
            explorer.mergeTemporaryFiles(args[0]);
        }

    }
}
