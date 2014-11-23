package tests.task3;

import donnu.zolotarev.tpi.laba2.task1.IFileFinder;
import donnu.zolotarev.tpi.laba2.task1.SystemFileExplorer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tests.task1.FileTestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class SystemFileExplorerTest extends Assert {


    private SystemFileExplorer explorer;
    private  FileTestHelper fileHelper;


    @Before
    public void setUp() throws Exception {
        fileHelper =  spy(new FileTestHelper());
        explorer =  new SystemFileExplorer(fileHelper);
    }

    @After
    public void tearDown() throws Exception {
        fileHelper = null;
        explorer = null;
    }

    @Test
    public void mockTestMergeTemporaryFilesUseCreateFile() {

        explorer.mergeTemporaryFiles("");
        verify(fileHelper).createFile(anyString(),anyString());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseDeleteFileByName() {
        explorer.mergeTemporaryFiles("");
        verify(fileHelper).deleteFilesByName( Mockito.anyCollection());
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFilesName() {
        explorer.mergeTemporaryFiles("");
        verify(fileHelper).getFilesNames();
    }

    @Test
    public void mockTestMergeTemporaryFilesUseGetFileByName() {

        explorer.mergeTemporaryFiles("");
        verify(fileHelper).getFilesNames();
    }

    @Test
    public void stubTestCreateBackup() {
        IFileFinder mockedList = mock(IFileFinder.class);
        when(mockedList.getFileBodyByName("1")).thenReturn("qwer");
        when(mockedList.getFileBodyByName("2")).thenReturn("1234");

        List<String> arrFileName = Arrays.asList("1", "2");

        explorer = new SystemFileExplorer(mockedList);
        String resString =  explorer.createBackup(arrFileName);
        Assert.assertTrue("qwer1234".equals(resString));
    }

    @Test
    public void stubTestGetFileWithExp() {

        IFileFinder mockedList = mock(IFileFinder.class);
        when(mockedList.getFilesNames()).thenReturn(Arrays.asList("file.tmp", "file2.tmp", "file.txt"));
        Collection<String> startArr = fileHelper.getFilesNames();
        ArrayList<String> resCol = new ArrayList<String>();

        resCol.addAll(explorer.getFileWithExp(startArr, ".tmp"));

        assertTrue(resCol.size() == 2);
        assertTrue(resCol.get(0).equals("file.tmp"));
        assertTrue(resCol.get(1).equals("file2.tmp"));
    }

    public void stubTestDeleteTecordedFiles() {
        IFileFinder mockedList = mock(IFileFinder.class);
        when(mockedList.getFilesNames()).thenReturn(Arrays.asList("file.tmp", "file2.tmp", "file.txt"));
        Collection<String> startArr = fileHelper.getFilesNames();
        ArrayList<String> endArr = new ArrayList<String>();

        explorer.getFileWithExp(startArr, ".tmp");

        endArr.addAll(fileHelper.getFilesNames());
        assertTrue(endArr.size() == 2);
        assertTrue(endArr.get(0).equals("file.txt"));
        assertTrue(endArr.get(1).equals("backup.tmp"));
    }
}