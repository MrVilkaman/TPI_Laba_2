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
            public double determinant() {
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
        linearEquationsSystem = new LinearEquationsSystem(new IMatrix() {
            @Override
            public double determinant() {
                return 0;
            }
        });
        linearEquationsSystem.setCoefficients(new double[][]{});
        linearEquationsSystem.solve();

    }


    public void testSolve3n() {
        linearEquationsSystem = new LinearEquationsSystem(new IMatrix() {
            @Override
            public double determinant() {
                return 0;
            }
        });
        linearEquationsSystem.setCoefficients(new double[][]{});
        linearEquationsSystem.solve();

    }

    public void mockUseDeterminantSolve() {
        MatrixTest matrixTest =  new MatrixTest();
        linearEquationsSystem = new LinearEquationsSystem(matrixTest);
        linearEquationsSystem.setCoefficients(new double[][]{});

        assertFalse(matrixTest.isUseDeterminant());
        linearEquationsSystem.solve();
        assertTrue(matrixTest.isUseDeterminant());

    }


    @Test(expected = NullPointerException.class)
    public void testSetCoefficients() {
        linearEquationsSystem = new LinearEquationsSystem(matrix);
        linearEquationsSystem.setCoefficients(null);
    }
}