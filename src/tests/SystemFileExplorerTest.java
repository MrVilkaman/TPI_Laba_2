package tests;

import donnu.zolotarev.tpi.laba2.SystemFileExplorer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SystemFileExplorerTest extends Assert {


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

    @Test
    public void stubTestCreateBackup() {
        List<String> arrFileName = Arrays.asList("1", "2");
        String resString =  explorer.createBackup(arrFileName);
       // Arrays.asList("file.tmp", "file2.tmp", "file.txt")
        Assert.assertTrue("qwer1234".equals(resString));
    }

    @Test
    public void stubTestGetFileWithExp() {
        Collection<String> startArr = fileHelper.getFilesNames();
        ArrayList<String> resCol = new ArrayList<String>();

        resCol.addAll(explorer.getFileWithExp(startArr, ".tmp"));

        assertTrue(resCol.size() == 2);
        assertTrue(resCol.get(0).equals("file.tmp"));
        assertTrue(resCol.get(1).equals("file2.tmp"));
    }

    public void stubTestDeleteTecordedFiles() {
        Collection<String> startArr = fileHelper.getFilesNames();
        ArrayList<String> endArr = new ArrayList<String>();

        explorer.getFileWithExp(startArr, ".tmp");

        endArr.addAll(fileHelper.getFilesNames());
        assertTrue(endArr.size() == 2);
        assertTrue(endArr.get(0).equals("file.txt"));
        assertTrue(endArr.get(1).equals("backup.tmp"));
    }
}