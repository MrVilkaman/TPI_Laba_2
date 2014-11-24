package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.IMatrix;
import donnu.zolotarev.tpi.laba2.task2.LinearEquationsSystem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinearGetMatrixTests extends Assert{

    private static LinearEquationsSystem linearEquationsSystem;
    private static IMatrix matrix;

    @BeforeClass
    public static void  setUpClass(){
        matrix = new IMatrix() {
            @Override
            public double determinant(double[][]  a) {
                return 1;
            }
        };
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(new double[][]{
                {5, 4, 2,1},
                {2, 1, 2,1},
                {2, 3, 4,1},});


    }

    @Test()
    public void testDeterminateMatrix() {

        double[][] res = linearEquationsSystem.getMatrix(0);
        assertArrayEquals(res,new double[][]{
                {5, 4, 2},
                {2, 1, 2},
                {2, 3, 4}
        });
    }


    @Test()
    public void testDeterminate1Matrix() {

        double[][] res = linearEquationsSystem.getMatrix(1);

        assertArrayEquals(res,new double[][]{
                {1, 4, 2},
                {1, 1, 2},
                {1, 3, 4}
        });
    }

    @Test()
    public void testDeterminate2Matrix() {

        double[][] res = linearEquationsSystem.getMatrix(2);
        assertArrayEquals(res,new double[][]{
                {5, 1, 2},
                {2, 1, 2},
                {2, 1, 4}
        });
    }

    @Test()
    public void testDeterminate3Matrix() {

        double[][] res = linearEquationsSystem.getMatrix(3);
        assertArrayEquals(res,new double[][]{
                {5, 4, 1},
                {2, 1, 1},
                {2, 3, 1}
        });
    }

}
