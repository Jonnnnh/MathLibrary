package ru.vsu.cs.tulitskayte_d_v.math.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;
import ru.vsu.cs.tulitskayte_d_v.math.matrix.*;
import ru.vsu.cs.tulitskayte_d_v.math.vector.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Matrix4Test {

    @Test
    void testInputValuesExpectedException() {

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5, 6}};
            Matrix m = new Matrix4(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5},
                    {6, 7, 8}};
            Matrix m = new Matrix4(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5, 6},
                    {6, 7}};
            Matrix m = new Matrix4(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[0][0];
            Matrix m = new Matrix4(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

    }

    @Test
    void testMultiplyMatrixOnVector() {

        float[] expected = new float[]{62.5405f,
                409.7973f,
                116.976f,
                107};

        float[][] m = {{0, -2, 3.009f, 11},
                {4.9f, 5, -0.0006f, 77},
                {7, -0.008f, 9, 12.5f},
                {10, 11, 12, 0}
        };
        float[] v = {2, 3, 4.5f, 5};

        Matrix matrix = new Matrix4(m);
        Vector vector = new Vector4(v);

        vector = matrix.productMatrixOnVector(matrix, vector);

        float exp = 0.000001f;
        assertArrayEquals(expected, vector.getValues(), exp);

        v = new float[]{0, 0, 0, 0};
        vector = new Vector4(v);
        vector = matrix.productMatrixOnVector(matrix, vector);
        vector.getValues();
        expected = new float[]{0, 0, 0, 0};
        assertArrayEquals(expected, vector.getValues());

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            };
            float[] vInput = {2, 3};

            Matrix mIn = new Matrix4(mInput);
            Vector vIn = new Vector2(vInput);

            Vector vectorRes = mIn.productMatrixOnVector(mIn, vIn);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            };
            float[] vInput = {2, 3, 4};

            Matrix mIn = new Matrix4(mInput);
            Vector vIn = new Vector3(vInput);

            Vector vectorRes = mIn.productMatrixOnVector(mIn, vIn);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());
    }
}