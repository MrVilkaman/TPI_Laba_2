package tests;

import donnu.zolotarev.tpi.laba2.SystemFileExplorer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SystemFileExplorerTest extends Assert{


    private SystemFileExplorer explorer;
    private FileTestHelper fileHelper;


    @Before
    public void setUp() throws Exception {
        fileHelper = new FileTestHelper();
        explorer =  new SystemFileExplorer(fileHelper);
    }

    @After
    public void tearDown() throws Exception {
        fileHelper = null;
        explorer = null;
    }

    @Test
    public void mockTestMergeTemporaryFilesUseCreateFile() {
        assertFalse(fileHelper.isUseCreateFile());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseCreateFile());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseDeleteFileByName() {
        assertFalse(fileHelper.isUseDeleteFileByName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseDeleteFileByName());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFilesName() {
        assertFalse(fileHelper.isUseGetFilesName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseGetFilesName());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFileByName() {

        assertFalse(fileHelper.isUseGetFileByName());
        explorer.mergeTemporaryFiles("");
        assertTrue(fileHelper.isUseGetFileByName());
    }


}