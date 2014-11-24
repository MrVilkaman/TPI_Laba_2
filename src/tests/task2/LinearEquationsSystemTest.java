package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.IMatrix;
import donnu.zolotarev.tpi.laba2.task2.LinearEquationsSystem;
import donnu.zolotarev.tpi.laba2.task2.Matrix;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinearEquationsSystemTest extends Assert {

    private LinearEquationsSystem linearEquationsSystem;
    private static IMatrix matrix;

    @BeforeClass
    public static void setUpClass(){
        matrix = new IMatrix() {
            @Override
            public double determinant(double[][]  a) {
                return 1;
            }
        };
    }

    @Test(expected = RuntimeException.class)
    public void testZeroDetSolve() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(null);
        linearEquationsSystem.solve();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroEmptyArray() {
        MatrixStub matrixStub =  new MatrixStub();
        linearEquationsSystem = new LinearEquationsSystem(matrixStub);
        linearEquationsSystem.setCoefficients(new double[][]{});

        assertFalse(matrixStub.isUseDeterminant());
        linearEquationsSystem.solve();
        assertTrue(matrixStub.isUseDeterminant());
    }


    @Test(expected = NullPointerException.class)
    public void testSetCoefficients() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(null);
    }

    @Test()
    public void testByRealParams() {
        linearEquationsSystem = new LinearEquationsSystem(new Matrix());
        linearEquationsSystem.setCoefficients(new double[][]{
                {2,5,4,30},
                {1,3,2,150},
                {2,10,9,110},
        });

        double[] res = linearEquationsSystem.solve();

        assertArrayEquals(res,new double[]{-152,270,-254},0.001);
    }

}