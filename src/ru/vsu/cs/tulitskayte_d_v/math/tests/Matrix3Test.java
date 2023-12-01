package ru.vsu.cs.tulitskayte_d_v.math.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.tulitskayte_d_v.math.matrix.MathExceptions;
import ru.vsu.cs.tulitskayte_d_v.math.matrix.Matrix;
import ru.vsu.cs.tulitskayte_d_v.math.matrix.Matrix3;
import ru.vsu.cs.tulitskayte_d_v.math.vector.*;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Matrix3Test {

    @Test
    void testInputValuesExpectedException() {

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5, 6}};
            Matrix m = new Matrix3(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5},
                    {6, 7, 8}};
            Matrix m = new Matrix3(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[][]{{1, 2, 3},
                    {4, 5, 6},
                    {6, 7}};
            Matrix m = new Matrix3(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] expected = new float[0][0];
            Matrix m = new Matrix3(expected);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

    }

    @Test
    void testMultiplyMatrixOnVector() {
        float[][] m = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        float[] v = {2, 3, 4};

        Matrix m1 = new Matrix3(m);
        Vector v1 = new Vector3(v);

        Vector vectorResult = m1.productMatrixOnVector(m1, v1);
        float[] actual = vectorResult.getValues();
        float[] expected = {20, 47, 74};

        assertArrayEquals(expected, actual, 0.000001f);


        v = new float[]{0, 0, 0};
        v1 = new Vector3(v);
        vectorResult = m1.productMatrixOnVector(m1, v1);
        actual = vectorResult.getValues();
        expected = new float[]{0, 0, 0};
        assertArrayEquals(expected, actual);

        MathExceptions thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
            float[] vInput = {2, 3};

            Matrix matrix = new Matrix3(mInput);
            Vector vector = new Vector2(vInput);

            Vector vectorRes = matrix.productMatrixOnVector(matrix, vector);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

        thrown = Assertions.assertThrows(MathExceptions.class, () -> {
            float[][] mInput = {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}};
            float[] vInput = {2, 3, 4, 5};

            Matrix matrix = new Matrix3(mInput);
            Vector vector = new Vector4(vInput);

            Vector vectorRes = matrix.productMatrixOnVector(matrix, vector);
        });
        Assertions.assertEquals("Error in values!", thrown.getMessage());

    }
}