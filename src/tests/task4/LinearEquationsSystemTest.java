package tests.task4;

import donnu.zolotarev.tpi.laba2.task2.IMatrix;
import donnu.zolotarev.tpi.laba2.task2.LinearEquationsSystem;
import donnu.zolotarev.tpi.laba2.task2.Matrix;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LinearEquationsSystemTest extends Assert {

    private LinearEquationsSystem linearEquationsSystem;
    private static IMatrix matrix;

    @BeforeClass
    public static void setUpClass(){

        matrix = spy(new Matrix());
    }


    @Test()
    public void testCallsDeterninat() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(new double[][]{
                {2,5,4,30},
                {1,3,2,150},
                {2,10,9,110},
        });

        linearEquationsSystem.solve();
        verify(matrix,times(4)).determinant(any(double[][].class));
    }

    @Test()
    public void mockDeterninat() {
        IMatrix matrix = mock(IMatrix.class);
        when(matrix.determinant(any(double[][].class)))
                .thenReturn(5.)
                .thenReturn(-760.)
                .thenReturn(1350.)
                .thenReturn(-1270.);

        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(new double[][]{
                {2,5,4,30},
                {1,3,2,150},
                {2,10,9,110},
        });

        double[] res = linearEquationsSystem.solve();
        assertArrayEquals(res,new double[]{-152,270,-254},0.001);
    }

}