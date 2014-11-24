package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.IMatrix;
import donnu.zolotarev.tpi.laba2.task2.LinearEquationsSystem;
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
    /*{
                {-1,1,1},
                {-1,1,1},
                {-1,1,1},
        }*/


    @Test(expected = RuntimeException.class)
    public void testZeroDetSolve() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(new double[][]{});
        linearEquationsSystem.solve();
    }


    public void testSolve3n() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(new double[][]{});
        linearEquationsSystem.solve();

    }




    public void mockUseDeterminantSolve() {
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
}