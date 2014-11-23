package tests;

import donnu.zolotarev.tpi.laba2.SystemFileExplorer;
import org.junit.Assert;
import org.junit.Test;

public class SystemFileExplorerTest extends Assert{



    @Test
    public void mockTestMergeTemporaryFilesUseCreateFile() {
        FileTestHelper fileHelper = new FileTestHelper();
        SystemFileExplorer explorer =  new SystemFileExplorer(fileHelper);
        assertFalse(fileHelper.isUseCreateFile());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseCreateFile());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseDeleteFileByName() {
        FileTestHelper fileHelper = new FileTestHelper();
        SystemFileExplorer explorer =  new SystemFileExplorer(fileHelper);
        assertFalse(fileHelper.isUseDeleteFileByName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseDeleteFileByName());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFilesName() {
        FileTestHelper fileHelper = new FileTestHelper();
        SystemFileExplorer explorer =  new SystemFileExplorer(fileHelper);
        assertFalse(fileHelper.isUseGetFilesName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseGetFilesName());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFileByName() {
        FileTestHelper fileHelper = new FileTestHelper();
        SystemFileExplorer explorer =  new SystemFileExplorer(fileHelper);
        assertFalse(fileHelper.isUseGetFileByName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseGetFileByName());
    }
}